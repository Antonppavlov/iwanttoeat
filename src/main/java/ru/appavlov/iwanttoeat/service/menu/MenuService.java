package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.food.CalorieCalculation;

@Service
public class MenuService {

//    Для учительницы, которую мы взяли для примера, суточная калорийность составляет 1745 ккал.
//    Делим эту цифру на 6 частей микронутриентов (1 + 1 + 4). Одна часть составляет 290,8 ккал (округляем до 291 ккал).
//    Следовательно, с белками женщина должна получать 291 ккал, столько же с жирами, а с углеводами - 1164 ккал (291 × 4).
//
//    Суточное количество белков - 291 ккал/ 4 ккал = 72,75 г.
//    Суточное количество жиров - 291 ккал/ 9 ккал = 32,3 г.
//    Суточное количество углеводов - 1164 ккал/ 4 ккал = 291 г.

    public CalorieCalculation calories(boolean gender, int age, int height, int weight, int activity, int target) {
        int calories = calculateCaloriesWithTheGoalInMind(gender, age, height, weight, activity, target);
        int proteins = (calories / 6) / 4;
        int fats = (calories / 6) / 9;
        int carbohydrates = ((calories / 6) * 4) / 4;

        return new CalorieCalculation(calories, proteins, fats, carbohydrates);
    }

    private int calculateCaloriesWithTheGoalInMind(boolean gender, int age, int height, int weight, int activity, int target) {
        double targetValue = Params.GoalOfProperNutrition.values()[target].getValue();
        double calorieTargetCalculation = calculationOfCalorieNormsAllowanceActivity(gender, age, height, weight, activity) + targetValue;

        if (calorieTargetCalculation < 1450) {
            calorieTargetCalculation = 1450;
        }

        return (int) calorieTargetCalculation;
    }

    private double calculationOfCalorieNormsAllowanceActivity(boolean gender, int age, int height, int currentWeight, int activity) {
        double physicalActivityValue = Params.PhysicalActivity.values()[activity].getValue();
        double calorieNormalCalculation = calorieNormalCalculation(gender, age, height, currentWeight);
        return calorieNormalCalculation * physicalActivityValue;
    }

    private double calorieNormalCalculation(boolean gender, int age, int height, int currentWeight) {
        double genderNeedCalories;

        if (gender) {
            genderNeedCalories = 66.47 + 13.75 * currentWeight + 5.0 * height - 6.74 * age;
        } else {
            genderNeedCalories = 655.1 + 9.6 * currentWeight + 1.85 * height - 4.68 * age;
        }

        return genderNeedCalories;
    }

}

