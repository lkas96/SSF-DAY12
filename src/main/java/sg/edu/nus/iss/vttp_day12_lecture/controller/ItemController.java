package sg.edu.nus.iss.vttp_day12_lecture.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import sg.edu.nus.iss.vttp_day12_lecture.model.Item;
import sg.edu.nus.iss.vttp_day12_lecture.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("")
    public String cartItems(Model model) {

        // For list of items
        List<Item> items = itemService.getItem();
        model.addAttribute("itemList", items);

        // For time accessed
        model.addAttribute("currTime", (new Date()).toString());

        // For greeting
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));

        //Pass it to cartlist.html
        return "cartlist";
    }

    //http://localhost:8080/items/filter?itemQuantity=5 
    @GetMapping("/filter")
    public String filterCartItems(@RequestParam(name = "itemQuantity") String quantity, Model model) {

        // For list of items
        List<Item> items = itemService.getItem();
        List<Item> filtered = items.stream().filter(a -> a.getQuantity() > Integer.parseInt(quantity)).collect(Collectors.toList()); //Filter and show results more than 5
        model.addAttribute("itemList", filtered);

        // For time accessed
        model.addAttribute("currTime", (new Date()).toString());

        // For greeting
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));

        //Pass it to cartlist.html
        return "cartlist";
    }
}
