package ru.appavlov.iwanttoeat.controller.food;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.service.dao.food.FoodSubtypeDAO;

@Log
@RestController
@RequestMapping(path = "/food/subtype")
public class FoodSubtypeController {

    @Autowired
    private FoodSubtypeDAO service;

}

