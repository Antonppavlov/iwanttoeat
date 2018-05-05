package ru.appavlov.iwanttoeat.controller.menu;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
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

    @GetMapping
    public MenuForTheDay menuGet(
            @RequestParam("calorie") int calorie,
            @RequestParam("proteins") int proteins,
            @RequestParam("fats") int fats,
            @RequestParam("carbohydrates") int carbohydrates
    ) {
        return menuCalculateService.calculation(
                new CaloriesAndPFC(calorie, proteins, fats, carbohydrates)
        );
    }

    @PostMapping
    public MenuForTheDay menuPost(@RequestBody CaloriesAndPFC caloriesAndPFC) {
        return menuCalculateService.calculation(caloriesAndPFC);
    }

    @GetMapping(value = "caloriesPerFood")
    public FoodIntake menu(@RequestParam int foodId, @RequestParam double caloriesPerFood) {
        return calculateFoodService.calculateCaloriesIntake(foodId, caloriesPerFood);
    }
}
