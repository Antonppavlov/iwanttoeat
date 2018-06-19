package ru.appavlov.iwanttoeat.service.menu.interfaces;

import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.model.menu.CPFC;
import ru.appavlov.iwanttoeat.model.menu.FoodAndPercent;
import ru.appavlov.iwanttoeat.model.menu.FoodIntake;

public interface IFoodCalculateService {

    FoodIntake calculateFoodIntake(String name, double caloriesPerFood, FoodAndPercent... foodAndPercents);

    CPFC calculateCaloriesFood(Food food, double caloriesPerFood);

    CPFC calculationCPFCStandardFood(Food food);


}
