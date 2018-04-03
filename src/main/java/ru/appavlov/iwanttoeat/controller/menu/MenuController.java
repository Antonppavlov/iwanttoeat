package ru.appavlov.iwanttoeat.controller.menu;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.service.menu.MenuService;

@Log
@RestController
@RequestMapping(path = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/calories")
    public int get(
            @RequestParam("gender") boolean gender,
            @RequestParam("age") long age,
            @RequestParam("height") long height,
            @RequestParam("currentWeight") long currentWeight,
            @RequestParam("desiredWeight") long desiredWeight) {
        int calories = menuService.calculateTheRequiredCalories(gender, age, height, currentWeight, desiredWeight);

        return calories;
    }


}

