package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.model.food.FoodProducts;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;
import ru.appavlov.iwanttoeat.model.menu.MenuForTheDay;
import ru.appavlov.iwanttoeat.model.product.ProductData;
import ru.appavlov.iwanttoeat.service.impl.food.FoodService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    public FoodService foodService;

    public MenuForTheDay calculation(CaloriesAndPFC caloriesAndPFC) {
        //вернуть меню на день рассчитанное по переданным CaloriesAndPFC
        //приемов пищи 5
        //каждый прием пищи должен быть @params caloriesAndPFC.getCalorie() / 5
        //пока нет учета БЖУ
        //TODO первый прием
        // - "первые блюда" + "напитики"

        //TODO второй прием
        // - "бутерброды"

        //TODO третий прием
        //горяиче блюда
        //вторые блюда

        //TODO четвертый прием
        //вторые блюда
        //салат

        //TODO пятый прием
        //вторые блюда
        //салат


        //TODO нужно создать метод который будет отдавать составленный прием пищи
        //принимает caloriesAndPFC / 5
        //принимает лист из выбранных food
        //процент по каждому food на прием пищи

        //возвращает объект "Прием пищи" с листом food / количесто грамм продуктов в каждом блюде

        return null;
    }

    public MenuForTheDay menu() {

        int calorie = 2500;
        int proteins = 182;
        int fats = 69;
        int carbohydrates = 337;

        CaloriesAndPFC caloriesAndPFC = new CaloriesAndPFC(calorie, proteins, fats, carbohydrates);
        int intake1Percent = 20;
        int intake2Percent = 10;
        int intake3Percent = 30;
        int intake4Percent = 20;
        int intake5Percent = 15;

        int intake1Calories = calorie * intake1Percent / 100;
        int intake2Calories = calorie * intake2Percent / 100;
        int intake3Calories = calorie * intake3Percent / 100;
        int intake4Calories = calorie * intake4Percent / 100;
        int intake5Calories = calorie * intake5Percent / 100;

        //приемов пищи 5
        //TODO первый прием
        // - "первые блюда" + "напитики"
        Map<Double, Food> foodMap = new HashMap<>();
        foodMap.put(75.0, foodService.get(293));
        foodMap.put(25.0, foodService.get(332));
        calculateCaloriesIntake(intake1Calories, foodMap);
        FoodIntake foodIntake1 = new FoodIntake("Первый прием пищи", foodMap, calculateCaloriesIntake(intake1Calories, foodMap));
//        FoodIntake foodIntake1 = a(intake1Calories,);


        //TODO второй прием
        // - "бутерброды"

        //TODO третий прием
        //горяиче блюда
        //вторые блюда

        //TODO четвертый прием
        //вторые блюда
        //салат

        //TODO пятый прием
        //вторые блюда  /молочка
        //салат


        //TODO нужно создать метод который будет отдавать составленный прием пищи

        //возвращает объект "Прием пищи" с листом food / количесто грамм продуктов в каждом блюде

        return new MenuForTheDay(
                caloriesAndPFC,
                Arrays.asList(foodIntake1)
        );
    }


    private CaloriesAndPFC calculateCaloriesIntake(double caloriesPerFood, Map<Double, Food> foodMap) {
        int calorieIntake = 0;
        int proteinsIntake = 0;
        int fatsIntake = 0;
        int carbohydratesIntake = 0;

        for (Double percent : foodMap.keySet()) {
            CaloriesAndPFC caloriesFood = calculateCaloriesFood(foodMap.get(percent).getFoodProducts(), caloriesPerFood / 100 * percent);
            calorieIntake += caloriesFood.getCalorie();
            proteinsIntake += caloriesFood.getProteins();
            fatsIntake += caloriesFood.getFats();
            carbohydratesIntake += caloriesFood.getCarbohydrates();
        }


        return new CaloriesAndPFC(
                calorieIntake,
                proteinsIntake,
                fatsIntake,
                carbohydratesIntake);
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

