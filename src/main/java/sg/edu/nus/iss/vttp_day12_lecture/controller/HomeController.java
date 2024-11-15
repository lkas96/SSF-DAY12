package sg.edu.nus.iss.vttp_day12_lecture.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Add annotation, auto generated template does not have it. Will not work
            // without annotation.

@RequestMapping("/home")
public class HomeController {

    // @GetMapping(path = { "", "/landing" })
    // public String home() {
    //     return "home";
    // }

    // @GetMapping(produces = { "text/html" })
    // @GetMapping(path = { "", "/landing" })
    // public String home(Model model) {
    //     model.addAttribute("currTime", (new Date()).toString());
    //     return "home";
    // }

    @GetMapping(path = {"", "/landing"})
    // @RequestMapping(path = {"", "/landing"}, method=RequestMethod.GET)    
    public String home(Model model) {
        model.addAttribute("currTime", (new Date()).toString());

        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));
        return "home";
    }
    

}
