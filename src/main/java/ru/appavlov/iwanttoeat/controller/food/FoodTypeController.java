package ru.appavlov.iwanttoeat.controller.food;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.model.food.FoodType;
import ru.appavlov.iwanttoeat.service.dao.food.FoodTypeDAO;

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

}

