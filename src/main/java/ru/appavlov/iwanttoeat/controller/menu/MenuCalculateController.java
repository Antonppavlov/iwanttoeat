package ru.appavlov.iwanttoeat.controller.menu;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.appavlov.iwanttoeat.model.menu.CPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.menu.MenuForTheDay;
import ru.appavlov.iwanttoeat.service.menu.MenuCalculateService;

@Log
@RestController
@RequestMapping(path = "/menu")
public class MenuCalculateController {

    @Autowired
    private MenuCalculateService menuCalculateService;

    @GetMapping
    public MenuForTheDay menuGet(
            @RequestParam("calories") int calories,
            @RequestParam("proteins") int proteins,
            @RequestParam("fats") int fats,
            @RequestParam("carbohydrates") int carbohydrates) {

        return menuCalculateService.calculation(new CPFC(calories, proteins, fats, carbohydrates));
    }

    @PostMapping
    public MenuForTheDay menuPost(@RequestBody CPFC CPFC) {
        return menuCalculateService.calculation(CPFC);
    }

    @GetMapping(value = "food_standard")
    public FoodIntake foodStandard(@RequestParam int foodId) {
        return menuCalculateService.foodStandard(foodId);
    }
}
