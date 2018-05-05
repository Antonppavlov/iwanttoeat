package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;

@Data
public class CaloriesAndPFC {
    public int calorie;
    public int proteins;
    public int fats;
    public int carbohydrates;

    public CaloriesAndPFC() {
    }

    public CaloriesAndPFC(int calorie, int proteins, int fats, int carbohydrates) {
        this.calorie = calorie;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }
}
