package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;

@Data
public class CPFC {
    public int calories;
    public int proteins;
    public int fats;
    public int carbohydrates;

    public CPFC() {
    }

    public CPFC(double calories, double proteins, double fats, double carbohydrates) {
        this.calories = (int) Math.ceil(calories);
        this.proteins = (int) Math.ceil(proteins);
        this.fats = (int) Math.ceil(fats);
        this.carbohydrates = (int) Math.ceil(carbohydrates);
    }

    public CPFC(int calories, int proteins, int fats, int carbohydrates) {
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }
}
