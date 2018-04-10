package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.menu.MenuForTheDay;
import ru.appavlov.iwanttoeat.service.impl.food.FoodService;

import java.util.Arrays;

@Service
public class MenuService {

    @Autowired
    public FoodService foodService;

    public MenuForTheDay calculation(CaloriesAndPFC caloriesAndPFC) {
        //вернуть меню на день рассчитанное по переданным CaloriesAndPFC
        //приемов пищи 5
        //каждый прием пищи должен быть @params caloriesAndPFC.getCalorie() / 5
        //пока нет учета БЖУ
        //TODO первый прием
        // - "первые блюда" + "напитики"

        //TODO второй прием
        // - "бутерброды"

        //TODO третий прием
        //горяиче блюда
        //вторые блюда

        //TODO четвертый прием
        //вторые блюда
        //салат

        //TODO пятый прием
        //вторые блюда
        //салат


        //TODO нужно создать метод который будет отдавать составленный прием пищи
        //принимает caloriesAndPFC / 5
        //принимает лист из выбранных food
        //процент по каждому food на прием пищи

        //возвращает объект "Прием пищи" с листом food / количесто грамм продуктов в каждом блюде

        return null;
    }

    public MenuForTheDay menu() {

        int calorie = 2760;
        int proteins = 182;
        int fats = 69;
        int carbohydrates = 337;

        CaloriesAndPFC caloriesAndPFC = new CaloriesAndPFC(calorie, proteins, fats, carbohydrates);

        //приемов пищи 5
        //TODO первый прием
        // - "первые блюда" + "напитики"
        FoodIntake foodIntake1 = new FoodIntake(
                "первый",
                Arrays.asList(foodService.get(293), foodService.get(332))
        );

        //TODO второй прием
        // - "бутерброды"

        //TODO третий прием
        //горяиче блюда
        //вторые блюда

        //TODO четвертый прием
        //вторые блюда
        //салат

        //TODO пятый прием
        //вторые блюда
        //салат


        //TODO нужно создать метод который будет отдавать составленный прием пищи

        //возвращает объект "Прием пищи" с листом food / количесто грамм продуктов в каждом блюде

        return new MenuForTheDay(
                caloriesAndPFC,
                Arrays.asList(foodIntake1)
        );
    }
}

