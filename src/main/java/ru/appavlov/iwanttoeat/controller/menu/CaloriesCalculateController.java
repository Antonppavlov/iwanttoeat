package ru.appavlov.iwanttoeat.controller.menu;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.menu.CPFC;
import ru.appavlov.iwanttoeat.model.menu.HumanParam;
import ru.appavlov.iwanttoeat.service.menu.CaloriesCalculateService;

@Log
@RestController
@RequestMapping(path = "/calories")
public class CaloriesCalculateController {

    @Autowired
    private CaloriesCalculateService caloriesCalculateService;

    @GetMapping("/calculation")
    public CPFC calculation(
            @RequestParam("gender") boolean gender,
            @RequestParam("age") int age,
            @RequestParam("height") int height,
            @RequestParam("weight") int weight,
            @RequestParam("activity") int activity,
            @RequestParam("target") int target) {

        return caloriesCalculateService.calculationCPFC(gender, age, height, weight, activity, target);
    }

    @PostMapping("/calculation")
    public CPFC calculation(@RequestBody HumanParam humanParam) {
        return caloriesCalculateService.calculationCPFC(humanParam);
    }
}

