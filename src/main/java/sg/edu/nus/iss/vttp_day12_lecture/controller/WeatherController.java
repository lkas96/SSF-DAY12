package sg.edu.nus.iss.vttp_day12_lecture.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp_day12_lecture.model.Country;
import sg.edu.nus.iss.vttp_day12_lecture.service.CountryService;

import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    CountryService countryService;
    
    //http://localhost:8080/weather
    @GetMapping("")
    public String weather(  @RequestParam(required = true, name = "country", defaultValue = "Singapore") String city, 
                            @RequestParam(name = "metrics", defaultValue = "centimeters") String metric, Model model) {

        model.addAttribute("city", city);
        model.addAttribute("metrics", metric);

        return "weather";
    }

    //http://localhost:8080/weather/city/Malaysia/metrics/degrees
    @GetMapping(path = {"/city/{country}/metrics/{metrics}", "/{country}/{metrics}"})
    public String weather2(@PathVariable(required = true, name = "country") String city, @PathVariable(name = "metrics") String metric, Model model) {

        model.addAttribute("city", city);
        model.addAttribute("metrics", metric);

        return "weather";
    }

    @GetMapping("/pagea")
    public String pageA(Model model){

        String [] units = {"centimeters", "meters", "kilometers", "feet", "inches", "bananas"};

        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("metrics", units);

        return "pagea";
    }

    @GetMapping("/forma")
    public String showForm(){
        return "forma";
    }

    @PostMapping("/forma")
    public String handlePageA(@RequestBody MultiValueMap<String, String> form) {

        // Map<String, String> formData = new HashMap<>();
        
        for(String str: form.keySet()) {
            // formData.put(str, form.getFirst(str));
            System.out.println(str + ">>> " + form.getFirst(str));
        }
        
        //Returns back to forma, hence the loop
        return "forma";
    }
    
}
