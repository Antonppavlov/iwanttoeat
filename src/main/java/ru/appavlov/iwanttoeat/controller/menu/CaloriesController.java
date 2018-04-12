package ru.appavlov.iwanttoeat.controller.menu;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
import ru.appavlov.iwanttoeat.model.menu.HumanParam;
import ru.appavlov.iwanttoeat.service.menu.CaloriesService;

@Log
@RestController
@RequestMapping(path = "/calories")
public class CaloriesController {

    @Autowired
    private CaloriesService caloriesService;

    @GetMapping("/calculation")
    public CaloriesAndPFC calculation(
            @RequestParam("gender") boolean gender,
            @RequestParam("age") int age,
            @RequestParam("height") int height,
            @RequestParam("weight") int weight,
            @RequestParam("activity") int activity,
            @RequestParam("target") int target) {

        return caloriesService.caloriesAndPFC(gender, age, height, weight, activity, target);
    }

    @PostMapping("/calculation")
    public CaloriesAndPFC calculation(@RequestBody HumanParam humanParam) {
        return caloriesService.caloriesAndPFC(humanParam);
    }
}

