package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.menu.CPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodAndPercent;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.menu.MenuForTheDay;
import ru.appavlov.iwanttoeat.service.impl.food.FoodService;

import java.util.Arrays;

@Service
public class MenuCalculateService {

    @Autowired
    public FoodCalculateService calculateFoodService;

    @Autowired
    public CaloriesSumService caloriesSumService;

    @Autowired
    public FoodService foodService;

    public MenuForTheDay calculation(CPFC CPFC) {
        double calorie = CPFC.getCalories();

        double intake1Percent = 20.00;
        double intake2Percent = 10.00;
        double intake3Percent = 30.00;
        double intake4Percent = 20.00;
        double intake5Percent = 20.00;

        double intake1Calories = calorie * intake1Percent / 100.00;
        double intake2Calories = calorie * intake2Percent / 100.00;
        double intake3Calories = calorie * intake3Percent / 100.00;
        double intake4Calories = calorie * intake4Percent / 100.00;
        double intake5Calories = calorie * intake5Percent / 100.00;

        /*
        приемов пищи 5

        первый прием
        случайное из раздела выпичка
        случайное из раздела напитки
        */
        FoodIntake firstMeal =
                calculateFoodService.calculateFoodIntake(
                        "Первый прием пищи",
                        intake1Calories,
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(7), 75.00),
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(8), 25.00)
                );

        /*
        второй прием
        случайное из раздела "бутерброды"
        */
        FoodIntake secondMeal =
                calculateFoodService.calculateFoodIntake(
                        "Второй прием пищи",
                        intake2Calories,
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(5), 100.00)
                );

        /*
        третий прием
        случайное из раздела Первые блюда
        случайное из раздела Вторые блюда
        случайное из раздела Гарниры и соусы
        случайное из раздела Салаты
        */
        FoodIntake thirdMeal =
                calculateFoodService.calculateFoodIntake(
                        "Третий прием пищи",
                        intake3Calories,
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(1), 30.00),
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(2), 30.00),
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(10), 20.00),
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(3), 20.00)
                );

        /*
        четвертый прием
        случайное из раздела Вторые блюда
        случайное из раздела Гарниры и соусы
        случайное из раздела Консервирование
        */
        FoodIntake fourthMeal =
                calculateFoodService.calculateFoodIntake(
                        "Четвертый прием пищи",
                        intake4Calories,
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(2), 30.00),
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(10), 30.00),
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(9), 20.00)
                );

        /*
        //пятый прием
        //продукт молоко или ряженка или кефир
        //продукт творог
        */
        FoodIntake fifthMeal =
                calculateFoodService.calculateFoodIntake(
                        "Пятый прием пищи",
                        intake5Calories,
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(2), 60.00),
                        new FoodAndPercent(foodService.getRandomFoodWhereTypeId(10), 40.00)
                );


        CPFC allFoodIntakeCPFC =
                caloriesSumService.sumAllCPFC(
                        firstMeal.getCpfc(),
                        secondMeal.getCpfc(),
                        thirdMeal.getCpfc(),
                        fourthMeal.getCpfc(),
                        fifthMeal.getCpfc()
                );

        return new MenuForTheDay(
                allFoodIntakeCPFC,
                Arrays.asList(firstMeal, secondMeal, thirdMeal, fourthMeal, fifthMeal)
        );
    }


    public FoodIntake foodStandard(int foodId) {
        return calculateFoodService.calculateFoodIntake(foodService.get(foodId));
    }
}

