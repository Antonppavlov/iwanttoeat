package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.model.food.FoodProducts;
import ru.appavlov.iwanttoeat.model.menu.CPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodAndPercent;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.product.ProductData;
import ru.appavlov.iwanttoeat.service.menu.interfaces.IFoodCalculateService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoodCalculateService implements IFoodCalculateService {

    public FoodIntake calculateFoodIntake(final Food food) {
        CPFC cpfc = calculationCPFCStandardFood(food);
        return new FoodIntake("Рассчет блюда по стандартному рецепту", Arrays.asList(food), cpfc);
    }

    @Override
    public FoodIntake calculateFoodIntake(final String name, final double caloriesPerFood, FoodAndPercent... foodAndPercents) {
        double calorieIntake = 0;
        double proteinsIntake = 0;
        double fatsIntake = 0;
        double carbohydratesIntake = 0;

        List<Food> foods = new ArrayList<>();

        for (FoodAndPercent foodAndPercent : foodAndPercents) {
            Food food = foodAndPercent.getFood();

            CPFC caloriesFood = calculateCaloriesFood(
                    food, caloriesPerFood / 100.0 * foodAndPercent.getPercent()
            );

            calorieIntake += caloriesFood.getCalories();
            proteinsIntake += caloriesFood.getProteins();
            fatsIntake += caloriesFood.getFats();
            carbohydratesIntake += caloriesFood.getCarbohydrates();

            foods.add(food);
        }

        FoodIntake foodIntake = new FoodIntake(
                name,
                foods,
                new CPFC(
                        calorieIntake,
                        proteinsIntake,
                        fatsIntake,
                        carbohydratesIntake)
        );

        return foodIntake;
    }

    @Override
    public CPFC calculateCaloriesFood(Food food, double caloriesPerFood) {
        CPFC cpfcStandartFood = calculationCPFCStandardFood(food);

        double coefficient = caloriesPerFood / cpfcStandartFood.getCalories();

        for (FoodProducts product : food.getFoodProducts()) {

            if (product.getValue().doubleValue() > 0) {
                int valueCeil = (int) Math.ceil(product.getValue().doubleValue() * coefficient);
                BigDecimal bigDecimalValue = BigDecimal.valueOf(valueCeil);

                product.setValue(
                        bigDecimalValue
                );
            }
        }

        CPFC cpfc = new CPFC(
                cpfcStandartFood.getCalories() * coefficient,
                cpfcStandartFood.getProteins() * coefficient,
                cpfcStandartFood.getFats() * coefficient,
                cpfcStandartFood.getCarbohydrates() * coefficient);

        return cpfc;
    }

    @Override
    public CPFC calculationCPFCStandardFood(Food food) {
        double calorieIntake = 0;
        double proteinsIntake = 0;
        double fatsIntake = 0;
        double carbohydratesIntake = 0;

        for (FoodProducts product : food.getFoodProducts()) {
            double valueProducts = product.getValue().doubleValue();

            if (valueProducts > 0) {
                double coefficient = valueProducts / 100;

                ProductData productDataPer100Grams = product.getProduct().getData();

                calorieIntake += productDataPer100Grams.getCalories().doubleValue() * coefficient;
                proteinsIntake += productDataPer100Grams.getProteins().doubleValue() * coefficient;
                fatsIntake += productDataPer100Grams.getFats().doubleValue() * coefficient;
                carbohydratesIntake += productDataPer100Grams.getCarbohydrates().doubleValue() * coefficient;
            }
        }

        CPFC cpfc = new CPFC(
                calorieIntake,
                proteinsIntake,
                fatsIntake,
                carbohydratesIntake);

        return cpfc;
    }


}
