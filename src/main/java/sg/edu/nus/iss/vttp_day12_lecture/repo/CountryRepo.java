package sg.edu.nus.iss.vttp_day12_lecture.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp_day12_lecture.model.Country;

@Repository
public class CountryRepo {

    List<Country> countryList;

    public List<Country> getCountries() {

        countryList = new ArrayList<>();

        Country cty = new Country("SG", "Singapore", 6000000);
        countryList.add(cty);

        Country cty2 = new Country("PH", "Philippines", 539399443);
        countryList.add(cty2);

        Country cty3 = new Country("MY", "Malaysia", 4983853);
        countryList.add(cty3);

        Country cty4 = new Country("ID", "Indonesia", 273523615);
        countryList.add(cty4);

        Country cty5 = new Country("TH", "Thailand", 70538298);
        countryList.add(cty5);

        Country cty6 = new Country("VN", "Vietnam", 98162000);
        countryList.add(cty6);

        Country cty7 = new Country("JP", "Japan", 125500000);
        countryList.add(cty7);

        Country cty8 = new Country("KR", "South Korea", 51829023);
        countryList.add(cty8);

        Country cty9 = new Country("CN", "China", 1425671763);
        countryList.add(cty9);

        Country cty10 = new Country("IN", "India", 1428627662);
        countryList.add(cty10);

        Country cty11 = new Country("US", "United States", 338290000);
        countryList.add(cty11);

        Country cty12 = new Country("GB", "United Kingdom", 68215893);
        countryList.add(cty12);

        return countryList;
    }

    public Boolean createCountry(Country cty){
        if (countryList == null){
            countryList = new ArrayList<>();
        }

        countryList.add(cty);
        return true;
    }

}
