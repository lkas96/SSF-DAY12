package sg.edu.nus.iss.vttp_day12_lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp_day12_lecture.model.Country;
import sg.edu.nus.iss.vttp_day12_lecture.repo.CountryRepo;

@Service
public class CountryService {
    
    @Autowired
    CountryRepo countryRepo;

    public List<Country> getCountries(){
        return countryRepo.getCountries();
    }

    public Boolean createCountry(Country cty){
        Boolean result = countryRepo.createCountry(cty);
        return result;
    }
        


}
