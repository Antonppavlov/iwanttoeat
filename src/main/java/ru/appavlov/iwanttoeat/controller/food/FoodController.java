package ru.appavlov.iwanttoeat.controller.food;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.service.impl.food.FoodService;

import java.util.List;

@Log
@RestController
@RequestMapping(path = "/food")
public class FoodController {

    @Autowired
    private FoodService service;

    @RequestMapping("/all")
    public List<Food> getFoods() {
        return service.getAll();
    }

    @RequestMapping("/get")
    public Food get(@RequestParam("id") long id) {
        return service.get(id);
    }
}
