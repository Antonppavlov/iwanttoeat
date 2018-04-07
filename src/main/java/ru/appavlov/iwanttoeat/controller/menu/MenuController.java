package ru.appavlov.iwanttoeat.controller.menu;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.model.food.CalorieCalculation;
import ru.appavlov.iwanttoeat.service.menu.MenuService;

@Log
@RestController
@RequestMapping(path = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/calories")
    public CalorieCalculation get(
            @RequestParam("gender") boolean gender,
            @RequestParam("age") int age,
            @RequestParam("height") int height,
            @RequestParam("weight") int weight,
            @RequestParam("activity") int activity,
            @RequestParam("target") int target
    ) {
        return menuService.calories(gender, age, height, weight, activity, target);
    }


}

