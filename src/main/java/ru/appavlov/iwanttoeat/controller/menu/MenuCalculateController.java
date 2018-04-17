package ru.appavlov.iwanttoeat.controller.menu;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.menu.MenuForTheDay;
import ru.appavlov.iwanttoeat.service.menu.FoodCalculateService;
import ru.appavlov.iwanttoeat.service.menu.MenuCalculateService;

@Log
@RestController
@RequestMapping(path = "/menu")
public class MenuCalculateController {

    @Autowired
    private MenuCalculateService menuCalculateService;

    @Autowired
    private FoodCalculateService calculateFoodService;

//    @GetMapping("/calculation")
//    public MenuForTheDay calculateMenu() {
//
//        int calorie = 2760;
//        int proteins = 182;
//        int fats = 69;
//        int carbohydrates = 337;
//
//        return menuService.calculation(new CaloriesAndPFC(calorie, proteins, fats, carbohydrates));
//    }


    @GetMapping(value = "default")
    public MenuForTheDay menu() {
        return menuCalculateService.menu();
    }

    @GetMapping(value = "caloriesPerFood")
    public FoodIntake menu(@RequestParam int foodId, @RequestParam double caloriesPerFood) {
        return calculateFoodService.calculateCaloriesIntake(foodId, caloriesPerFood);
    }
}

