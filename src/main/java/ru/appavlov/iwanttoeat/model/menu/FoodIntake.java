package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;
import ru.appavlov.iwanttoeat.model.food.Food;

import java.util.Map;

@Data
public class FoodIntake {
    private final String name;
    //TODO срочно выпилять костыль
    private final Map<Double, Food> foodMap;
    private final CaloriesAndPFC caloriesIntake;

    public FoodIntake(String name, Map<Double, Food> foodMap, int intakeCalories) {
        this.name = name;
        this.foodMap = foodMap;
        this.caloriesIntake = calculateCaloriesIntake(intakeCalories);
    }

    private CaloriesAndPFC calculateCaloriesIntake(double caloriesPerFood) {
        int calorieIntake = 0;
        int proteinsIntake = 0;
        int fatsIntake = 0;
        int carbohydratesIntake = 0;

        for (Double percent : foodMap.keySet()) {
            CaloriesAndPFC caloriesFood = foodMap.get(percent).calculateCaloriesFood(caloriesPerFood * percent / 100);
            calorieIntake += caloriesFood.getCalorie();
            proteinsIntake += caloriesFood.getProteins();
            fatsIntake += caloriesFood.getFats();
            carbohydratesIntake += caloriesFood.getCarbohydrates();
        }


        return new CaloriesAndPFC(
                calorieIntake,
                proteinsIntake,
                fatsIntake,
                carbohydratesIntake);
    }


}
