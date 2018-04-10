package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;
import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.model.food.FoodProducts;
import ru.appavlov.iwanttoeat.model.product.ProductData;

import java.util.List;

@Data
public class FoodIntake {
    private final String name;
    private final List<Food> foodList;
    private final CaloriesAndPFC caloriesIntake;

    public FoodIntake(String name, List<Food> foodList) {
        this.name = name;
        this.foodList = foodList;
        this.caloriesIntake = calculateCaloriesIntake();
    }

    private CaloriesAndPFC calculateCaloriesIntake() {
        int calorieIntake = 0;
        int proteinsIntake = 0;
        int fatsIntake = 0;
        int carbohydratesIntake = 0;

        for (Food food : foodList) {
            List<FoodProducts> foodProducts = food.getFoodProducts();
            for (FoodProducts product : foodProducts) {
                ProductData data = product.getProduct().getData();
                //TODO надо будет отключить
                //нужно попроавить в базе т.к. какое-то поле null некоректно

                double valueProducts = 0;
                if (product.getValue() != null) {
                    //получаю вес продукта
                    valueProducts = product.getValue().doubleValue();
                }

                if (data.getCalorieCalories() != null) {
                    calorieIntake += data.getCalorieCalories().doubleValue() * (valueProducts / 100);
                }
                if (data.getProteinsG() != null) {
                    proteinsIntake += data.getProteinsG().doubleValue() * (valueProducts / 100);
                }
                if (data.getFatsG() != null) {
                    fatsIntake += data.getFatsG().doubleValue() * (valueProducts / 100);
                }
                if (data.getCarbohydratesG() != null) {
                    carbohydratesIntake += data.getCarbohydratesG().doubleValue() * (valueProducts / 100);
                }

            }
        }
        return new CaloriesAndPFC(
                calorieIntake,
                proteinsIntake,
                fatsIntake,
                carbohydratesIntake);
    }


}
