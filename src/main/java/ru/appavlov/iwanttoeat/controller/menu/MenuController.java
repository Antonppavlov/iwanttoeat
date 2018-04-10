package ru.appavlov.iwanttoeat.controller.menu;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
import ru.appavlov.iwanttoeat.model.menu.MenuForTheDay;
import ru.appavlov.iwanttoeat.service.menu.MenuService;

@Log
@RestController
@RequestMapping(path = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/calculation")
    public MenuForTheDay calculateMenu() {

        int calorie = 2760;
        int proteins = 182;
        int fats = 69;
        int carbohydrates = 337;

        return menuService.calculation(new CaloriesAndPFC(calorie, proteins, fats, carbohydrates));
    }


    @GetMapping
    public MenuForTheDay menu() {
        return menuService.menu();
    }
}

