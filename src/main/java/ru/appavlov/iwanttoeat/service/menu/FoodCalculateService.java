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

    public FoodIntake calculateFoodIntake(Food food) {
        CPFC cpfc = calculationCPFCStandardFood(food);

        return new FoodIntake(cpfc, "Рассчет блюда по стандартному рецепту", Arrays.asList(food));
    }

    @Override
    public FoodIntake calculateFoodIntake(String name, double caloriesPerFood, FoodAndPercent... foodAndPercents) {
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
                new CPFC(
                        calorieIntake,
                        proteinsIntake,
                        fatsIntake,
                        carbohydratesIntake),
                name,
                foods
        );

        return foodIntake;
    }

    @Override
    public CPFC calculateCaloriesFood(Food food, double caloriesPerFood) {
        CPFC cpfcStandartFood = calculationCPFCStandardFood(food);

        double coefficient = caloriesPerFood / cpfcStandartFood.getCalories();

        for (FoodProducts product : food.getFoodProducts()) {
            // ProductData data = product.getProduct().getData();

            if (product.getValue().doubleValue() > 0) {
                BigDecimal bigDecimalValue = BigDecimal.valueOf(product.getValue().doubleValue() * coefficient);

//                BigDecimal bigDecimalCalories = BigDecimal.valueOf(data.getCalories().doubleValue() * coefficient);
//                BigDecimal bigDecimalProteins = BigDecimal.valueOf(data.getProteins().doubleValue() * coefficient);
//                BigDecimal bigDecimalFats = BigDecimal.valueOf(data.getFats().doubleValue() * coefficient);
//                BigDecimal bigDecimalCarbohydrates = BigDecimal.valueOf(data.getCarbohydrates().doubleValue() * coefficient);
//изменять только необходимый вес в блюде
                //осталыое пусть остается как для 100 грамм
                product.setValue(bigDecimalValue);
//                data.setCalories(bigDecimalCalories);
//                data.setProteins(bigDecimalProteins);
//                data.setFats(bigDecimalFats);
//                data.setCarbohydrates(bigDecimalCarbohydrates);
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

                double percentProductForCalculation = valueProducts / 100;

                ProductData productDataPer100Grams = product.getProduct().getData();

                calorieIntake += productDataPer100Grams.getCalories().doubleValue() * percentProductForCalculation;
                proteinsIntake += productDataPer100Grams.getProteins().doubleValue() * percentProductForCalculation;
                fatsIntake += productDataPer100Grams.getFats().doubleValue() * percentProductForCalculation;
                carbohydratesIntake += productDataPer100Grams.getCarbohydrates().doubleValue() * percentProductForCalculation;
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
