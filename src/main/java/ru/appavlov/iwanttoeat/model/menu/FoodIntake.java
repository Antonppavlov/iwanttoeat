package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;
import ru.appavlov.iwanttoeat.model.food.Food;

import java.util.List;

@Data
public class FoodIntake {
    private final String name;
    private final List<Food> foods;
    private final CaloriesAndPFC caloriesIntake;

    public FoodIntake(String name, List<Food> foods, CaloriesAndPFC caloriesIntake) {
        this.name = name;
        this.foods = foods;
        this.caloriesIntake = caloriesIntake;
    }


}
