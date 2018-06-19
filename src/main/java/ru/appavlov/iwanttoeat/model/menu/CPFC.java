package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;

@Data
public class CPFC {
    public double calories;
    public double proteins;
    public double fats;
    public double carbohydrates;

    public CPFC() {
    }

    public CPFC(double calories, double proteins, double fats, double carbohydrates) {
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }
}
