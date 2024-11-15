package sg.edu.nus.iss.vttp_day12_lecture.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp_day12_lecture.model.Item;

@Repository //In repo folder, must add the repo tag else will not work
public class ItemRepo {

    private List<Item> itemList;
    
    public List<Item> getItem(){

        //Instantiate the array
        itemList = new ArrayList<>();

        //Adding item entries
        Item item = new Item("Apple M4 iPad", 2);
        itemList.add(item);

        Item item2 = new Item("Samsung S22 Ultra", 5);
        itemList.add(item2);

        Item item3 = new Item("Jia Fei Floptropica Ultra Cuntphone", 69);
        itemList.add(item3);

        return itemList;
    }
}
