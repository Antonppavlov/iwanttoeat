package ru.appavlov.iwanttoeat.controller.food;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.food.FoodName;
import ru.appavlov.iwanttoeat.service.dao.food.FoodNameDAO;

import java.util.List;

@Log
@RestController
@RequestMapping(path = "/food/name")
public class FoodNameController {

    @Autowired
    private FoodNameDAO service;

    @GetMapping
    public FoodName get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @GetMapping(value = "/search")
    public List<FoodName> search(@RequestParam("nameRu") String nameRu) {
        return service.search(nameRu);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody FoodName foodName) {
        service.save(foodName);
        return true;
    }
}
