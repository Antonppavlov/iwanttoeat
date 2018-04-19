package ru.appavlov.iwanttoeat.controller.food;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.food.FoodSubtype;
import ru.appavlov.iwanttoeat.service.dao.food.FoodSubtypeDAO;

import java.util.List;

@Log
@RestController
@RequestMapping(path = "/food/subtype")
public class FoodSubtypeController {

    @Autowired
    private FoodSubtypeDAO service;

    @GetMapping
    public FoodSubtype get(@RequestParam("id") long id) {
        return service.get(id);
    }

    @GetMapping(value = "/search")
    public List<FoodSubtype> search(@RequestParam("nameRu") String nameRu) {
        return service.search(nameRu);
    }

    @DeleteMapping
    public boolean delete(@RequestParam("id") long id) {
        service.delete(service.get(id));
        return true;
    }

    @PostMapping
    public boolean add(@RequestBody FoodSubtype foodSubtype) {
        service.save(foodSubtype);
        return true;
    }

}

