package ru.appavlov.iwanttoeat.controller.food;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.service.dao.food.FoodRecipeDAO;

@Log
@RestController
@RequestMapping(path = "/food/recipe")
public class FoodRecipeController {

    @Autowired
    private FoodRecipeDAO service;
}

