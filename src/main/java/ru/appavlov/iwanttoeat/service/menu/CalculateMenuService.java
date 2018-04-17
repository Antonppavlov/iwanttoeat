package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.menu.IdAndPercentFood;
import ru.appavlov.iwanttoeat.model.menu.MenuForTheDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CalculateMenuService {

    @Autowired
    public CalculateFoodService calculateFoodService;

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
        int calorie = 2500;
        int proteins = 182;
        int fats = 69;
        int carbohydrates = 337;

        CaloriesAndPFC caloriesAndPFC = new CaloriesAndPFC(calorie, proteins, fats, carbohydrates);
        int intake1Percent = 20;
        int intake2Percent = 10;
        int intake3Percent = 30;
        int intake4Percent = 20;
        int intake5Percent = 15;

        int intake1Calories = calorie * intake1Percent / 100;
        int intake2Calories = calorie * intake2Percent / 100;
        int intake3Calories = calorie * intake3Percent / 100;
        int intake4Calories = calorie * intake4Percent / 100;
        int intake5Calories = calorie * intake5Percent / 100;

        //приемов пищи 5
        //TODO первый прием
        // - "первые блюда" + "напитики"
        List<IdAndPercentFood> idAndPercentFoodList = new ArrayList<>();
        idAndPercentFoodList.add(new IdAndPercentFood(293, 75.0));
        idAndPercentFoodList.add(new IdAndPercentFood(332, 25.00));
        FoodIntake foodIntake =
                calculateFoodService.calculateCaloriesIntake(
                        "первый прием пищи",
                        idAndPercentFoodList,
                        intake1Calories
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
        //вторые блюда  /молочка
        //салат


        //TODO нужно создать метод который будет отдавать составленный прием пищи

        //возвращает объект "Прием пищи" с листом food / количесто грамм продуктов в каждом блюде

        return new MenuForTheDay(
                caloriesAndPFC,
                Arrays.asList(foodIntake)
        );
    }


}

