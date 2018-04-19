package ru.appavlov.iwanttoeat.controller.food;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.service.dao.food.FoodDAO;

@Log
@RestController
@RequestMapping(path = "/food")
public class FoodController {

    @Autowired
    private FoodDAO service;

    @GetMapping
    public Food get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody Food food) {
        service.save(food);
        return true;
    }
}
