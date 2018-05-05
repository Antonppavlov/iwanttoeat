package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.model.food.FoodProducts;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.menu.FoodTypeIdAndPercentFood;
import ru.appavlov.iwanttoeat.model.menu.IdAndPercentFood;
import ru.appavlov.iwanttoeat.model.product.ProductData;
import ru.appavlov.iwanttoeat.service.impl.food.FoodService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodCalculateService {

    @Autowired
    public FoodService foodService;

    public FoodIntake calculateCaloriesIntake(String name, double caloriesPerFood, FoodTypeIdAndPercentFood... foodTypeIdAndPercentFoods) {
        //TODO дублируется 99% кода в методе ниже
        int calorieIntake = 0;
        int proteinsIntake = 0;
        int fatsIntake = 0;
        int carbohydratesIntake = 0;
        List<Food> foods = new ArrayList<>();


        for (FoodTypeIdAndPercentFood foodTypeIdAndPercentFood : foodTypeIdAndPercentFoods) {
            Food food = foodService.getRandomFoodWhereTypeId(foodTypeIdAndPercentFood.getTypeId());

            CaloriesAndPFC caloriesFood =
                    calculateCaloriesFood(
                            food.getFoodProducts(),
                            caloriesPerFood / 100 * foodTypeIdAndPercentFood.getPercent()
                    );


            calorieIntake += caloriesFood.getCalorie();
            proteinsIntake += caloriesFood.getProteins();
            fatsIntake += caloriesFood.getFats();
            carbohydratesIntake += caloriesFood.getCarbohydrates();


            foods.add(food);
        }

        return new FoodIntake(
                new CaloriesAndPFC(
                        calorieIntake,
                        proteinsIntake,
                        fatsIntake,
                        carbohydratesIntake),
                name,
                foods
        );
    }

    public FoodIntake calculateCaloriesIntake(String name, double caloriesPerFood, IdAndPercentFood... idAndPercentFoodList) {
        //TODO дублируется 99% кода в методе выше
        int calorieIntake = 0;
        int proteinsIntake = 0;
        int fatsIntake = 0;
        int carbohydratesIntake = 0;
        List<Food> foods = new ArrayList<>();


        for (IdAndPercentFood idAndPercentFood : idAndPercentFoodList) {
            Food food = foodService.get(idAndPercentFood.getId());

            CaloriesAndPFC caloriesFood =
                    calculateCaloriesFood(
                            food.getFoodProducts(),
                            caloriesPerFood / 100 * idAndPercentFood.getPercent()
                    );


            calorieIntake += caloriesFood.getCalorie();
            proteinsIntake += caloriesFood.getProteins();
            fatsIntake += caloriesFood.getFats();
            carbohydratesIntake += caloriesFood.getCarbohydrates();


            foods.add(food);
        }

        return new FoodIntake(
                new CaloriesAndPFC(
                        calorieIntake,
                        proteinsIntake,
                        fatsIntake,
                        carbohydratesIntake),
                name,
                foods
        );

    }

    public FoodIntake calculateCaloriesIntake(int foodId, double caloriesPerFood) {
        return calculateCaloriesIntake(
                "Рассчет блюда",
                caloriesPerFood,
                new IdAndPercentFood(foodId, 100));
    }


    //TODO метод рабочий и подгоняет количество продуктов к нужным каллориям, но нужно срочно зарефакторить
    private CaloriesAndPFC calculateCaloriesFood(List<FoodProducts> foodProducts, double caloriesPerFood) {
        double calorieIntake = 0.1;
        double proteinsIntake = 0.1;
        double fatsIntake = 0.1;
        double carbohydratesIntake = 0.1;

        for (FoodProducts product : foodProducts) {
            //TODO надо будет отключить
            //нужно попроавить в базе т.к. какое-то поле null некоректно
            double valueProducts = 0;
            if (product.getValue() != null) {
                //получаю вес продукта
                valueProducts = product.getValue().doubleValue();
            }

            ProductData data = product.getProduct().getData();

            if (data.getCalories() != null) {
                calorieIntake += data.getCalories().doubleValue() * (valueProducts / 100);
            }
            if (data.getProteins() != null) {
                proteinsIntake += data.getProteins().doubleValue() * (valueProducts / 100);
            }
            if (data.getFats() != null) {
                fatsIntake += data.getFats().doubleValue() * (valueProducts / 100);
            }
            if (data.getCarbohydrates() != null) {
                carbohydratesIntake += data.getCarbohydrates().doubleValue() * (valueProducts / 100);
            }

        }

        //теперь вычисляем coefficient на сколько раз надо поделить каллории
        double coefficient = caloriesPerFood / calorieIntake;

        for (FoodProducts product : foodProducts) {
            //TODO надо будет отключить
            //нужно попроавить в базе т.к. какое-то поле null некоректно

            if (product.getValue() != null) {
                product.setValue(BigDecimal.valueOf(product.getValue().doubleValue() * coefficient));
            }

            ProductData data = product.getProduct().getData();

            if (data.getCalories() != null) {
                data.setCalories(BigDecimal.valueOf(data.getCalories().doubleValue() * coefficient));
            }
            if (data.getProteins() != null) {
                data.setProteins(BigDecimal.valueOf(data.getProteins().doubleValue() * coefficient));
            }
            if (data.getFats() != null) {
                data.setFats(BigDecimal.valueOf(data.getFats().doubleValue() * coefficient));
            }
            if (data.getCarbohydrates() != null) {
                data.setCarbohydrates(BigDecimal.valueOf(data.getCarbohydrates().doubleValue() * coefficient));
            }

        }

        return new CaloriesAndPFC(
                (int) (calorieIntake * coefficient),
                (int) (proteinsIntake * coefficient),
                (int) (fatsIntake * coefficient),
                (int) (carbohydratesIntake * coefficient));
    }
}
