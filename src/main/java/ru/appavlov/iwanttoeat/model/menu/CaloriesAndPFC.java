package ru.appavlov.iwanttoeat.model.menu;

import lombok.Getter;

@Getter
public class CaloriesAndPFC {
    private final int calorie;
    private final int proteins;
    private final int fats;
    private final int carbohydrates;

    public CaloriesAndPFC(int calorie, int proteins, int fats, int carbohydrates) {
        this.calorie = calorie;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }
}
