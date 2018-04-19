package ru.appavlov.iwanttoeat.controller.food;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.food.FoodType;
import ru.appavlov.iwanttoeat.service.dao.food.FoodTypeDAO;

import java.util.List;

@Log
@RestController
@RequestMapping(path = "/food/type")
public class FoodTypeController {

    @Autowired
    private FoodTypeDAO service;

    @GetMapping
    public FoodType get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @GetMapping(value = "/search")
    public List<FoodType> search(@RequestParam("nameRu") String nameRu) {
        return service.search(nameRu);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody FoodType foodType) {
        service.save(foodType);
        return true;
    }

}

