package ru.appavlov.iwanttoeat.controller.food;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.service.impl.food.FoodTypeService;

@Log
@RestController
@RequestMapping(path = "/food/type")
public class FoodTypeController {

    @Autowired
    private FoodTypeService service;

}

