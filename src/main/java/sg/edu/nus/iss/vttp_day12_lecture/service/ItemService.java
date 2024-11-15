package sg.edu.nus.iss.vttp_day12_lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp_day12_lecture.model.Item;
import sg.edu.nus.iss.vttp_day12_lecture.repo.ItemRepo;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    public List<Item> getItem() {

        return itemRepo.getItem();

    }
}
