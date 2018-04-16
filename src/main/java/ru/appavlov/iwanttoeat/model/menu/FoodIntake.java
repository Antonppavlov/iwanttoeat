package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;
import ru.appavlov.iwanttoeat.model.food.Food;

import java.util.Map;

@Data
public class FoodIntake {
    private final String name;
    private final Map<Double, Food> foodMap;
    private final CaloriesAndPFC caloriesIntake;

    public FoodIntake(String name, Map<Double, Food> foodMap, CaloriesAndPFC caloriesIntake) {
        this.name = name;
        this.foodMap = foodMap;
        this.caloriesIntake = caloriesIntake;
    }


}
