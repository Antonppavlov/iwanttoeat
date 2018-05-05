package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.menu.FoodTypeIdAndPercentFood;
import ru.appavlov.iwanttoeat.model.menu.MenuForTheDay;

import java.util.Arrays;

@Service
public class MenuCalculateService {

    @Autowired
    public FoodCalculateService calculateFoodService;

    @Autowired
    public CaloriesSumService caloriesSumService;


    public MenuForTheDay calculation(CaloriesAndPFC caloriesAndPFC) {
        double calorie = caloriesAndPFC.getCalorie();

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
                calculateFoodService.calculateCaloriesIntake(
                        "1 meal",
                        intake1Calories,
                        new FoodTypeIdAndPercentFood(7, 75.00),
                        new FoodTypeIdAndPercentFood(8, 25.00)
                );

        /*
        второй прием
        случайное из раздела "бутерброды"
        */
        FoodIntake secondMeal =
                calculateFoodService.calculateCaloriesIntake(
                        "2 meal",
                        intake2Calories,
                        new FoodTypeIdAndPercentFood(5, 100.00)
                );

        /*
        третий прием
        случайное из раздела Первые блюда
        случайное из раздела Вторые блюда
        случайное из раздела Гарниры и соусы
        случайное из раздела Салаты
        */
        FoodIntake thirdMeal =
                calculateFoodService.calculateCaloriesIntake(
                        "3 meal",
                        intake3Calories,
                        new FoodTypeIdAndPercentFood(1, 30.00),
                        new FoodTypeIdAndPercentFood(2, 30.00),
                        new FoodTypeIdAndPercentFood(10, 20.00),
                        new FoodTypeIdAndPercentFood(3, 20.00)
                );

        /*
        четвертый прием
        случайное из раздела Вторые блюда
        случайное из раздела Гарниры и соусы
        случайное из раздела Консервирование
        */
        FoodIntake fourthMeal =
                calculateFoodService.calculateCaloriesIntake(
                        "4 meal",
                        intake4Calories,
                        new FoodTypeIdAndPercentFood(2, 30.00),
                        new FoodTypeIdAndPercentFood(10, 30.00),
                        new FoodTypeIdAndPercentFood(9, 20.00)
                );

        /*
        //пятый прием
        //продукт молоко или ряженка или кефир
        //продукт творог
        */
        FoodIntake fifthMeal =
                calculateFoodService.calculateCaloriesIntake(
                        "5 meal",
                        intake5Calories,
                        new FoodTypeIdAndPercentFood(2, 60.00),
                        new FoodTypeIdAndPercentFood(10, 40.00)
                );


        CaloriesAndPFC allFoodIntakeCaloriesAndPFC =
                caloriesSumService.sumAllCaloriesAndPFC(
                        firstMeal.getCaloriesIntake(),
                        secondMeal.getCaloriesIntake(),
                        thirdMeal.getCaloriesIntake(),
                        fourthMeal.getCaloriesIntake(),
                        fifthMeal.getCaloriesIntake()
                );

        return new MenuForTheDay(
                allFoodIntakeCaloriesAndPFC,
                Arrays.asList(firstMeal, secondMeal, thirdMeal, fourthMeal, fifthMeal)
        );
    }


}

