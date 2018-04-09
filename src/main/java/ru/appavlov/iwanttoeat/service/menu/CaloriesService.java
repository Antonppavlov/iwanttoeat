package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.menu.CaloriesPerDay;

@Service
public class CaloriesService {

    public CaloriesPerDay calories(boolean gender, int age, int height, int weight, int activity, int target) {
        short percent100 = 100;

        short proteinsPercent = 27;
        short fatsPercent = 23;
        short carbohydratesPercent = 50;

        short caloriesInProteins = 4;
        short caloriesInFats = 9;
        short caloriesInCarbohydrates = 4;

        int calories = calculateCaloriesWithTheGoalInMind(gender, age, height, weight, activity, target);

        int proteins = ((calories / percent100) * proteinsPercent) / caloriesInProteins;
        int fats = ((calories / percent100) * fatsPercent) / caloriesInFats;
        int carbohydrates = ((calories / percent100) * carbohydratesPercent) / caloriesInCarbohydrates;

        return new CaloriesPerDay(calories, proteins, fats, carbohydrates);
    }

    private int calculateCaloriesWithTheGoalInMind(boolean gender, int age, int height, int weight, int activity, int target) {
        int minCalorie = 1450;
        double targetValue = Params.GoalOfProperNutrition.values()[target].getValue();
        double calorieTargetCalculation = calculationOfCalorieNormsAllowanceActivity(gender, age, height, weight, activity) + targetValue;

        if (calorieTargetCalculation < minCalorie) {
            calorieTargetCalculation = minCalorie;
        }

        return (int) calorieTargetCalculation;
    }

    private double calculationOfCalorieNormsAllowanceActivity(boolean gender, int age, int height, int currentWeight, int activity) {
        double physicalActivityValue = Params.PhysicalActivity.values()[activity].getValue();
        double calorieNormalCalculation = formulaCaloriesNormalCalculation(gender, age, height, currentWeight);
        return calorieNormalCalculation * physicalActivityValue;
    }

    private double formulaCaloriesNormalCalculation(boolean gender, int age, int height, int currentWeight) {
        double genderNeedCalories;

        if (gender) {
            genderNeedCalories = 66.47 + 13.75 * currentWeight + 5.0 * height - 6.74 * age;
        } else {
            genderNeedCalories = 655.1 + 9.6 * currentWeight + 1.85 * height - 4.68 * age;
        }

        return genderNeedCalories;
    }

}

