package sg.edu.nus.iss.vttp_day12_lecture.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp_day12_lecture.model.Country;
import sg.edu.nus.iss.vttp_day12_lecture.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @ResponseBody // Because never throw data to a display page, so just print the results bare
    @GetMapping("")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/list")
    public String countryList(Model model) {

        // For list of countries to throw to html
        List<Country> cty = countryService.getCountries();
        model.addAttribute("countries", cty);

        // For time accessed
        model.addAttribute("currTime", (new Date()).toString());

        // For greeting
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));

        return "countries";
    }


    //http://localhost:8080/countries/filter?population=5 
    @GetMapping("/filter")
    public String filterCountries(@RequestParam(name = "population") String population, Model model) {
        List<Country> countriesList = countryService.getCountries();
        List<Country> filtered = countriesList.stream().filter(a -> a.getPopulation() > Integer.parseInt(population))
                .collect(Collectors.toList());

        model.addAttribute("countries", filtered);

        // For time accessed
        model.addAttribute("currTime", (new Date()).toString());

        // For greeting
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));

        // Pass it to countries.html
        return "countries";
    }

}
