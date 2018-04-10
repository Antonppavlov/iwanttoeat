package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;

import java.util.List;

@Data
public class MenuForTheDay {
    private final CaloriesAndPFC caloriesDay;
    private final List<FoodIntake> foodIntakeList;

}
