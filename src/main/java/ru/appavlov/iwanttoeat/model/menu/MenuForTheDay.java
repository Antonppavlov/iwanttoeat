package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;

import java.util.List;

@Data
public class MenuForTheDay {
    private final CaloriesPerDay caloriesPerDay;
    private final List<FoodIntake> foodIntakeList;

}
