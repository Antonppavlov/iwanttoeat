package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;

@Data
public class CaloriesAndPFC {
    private final int calorie;
    private final int proteins;
    private final int fats;
    private final int carbohydrates;
}
