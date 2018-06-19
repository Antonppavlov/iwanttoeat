package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;
import ru.appavlov.iwanttoeat.model.food.Food;

@Data
public class FoodAndPercent {
    private final Food food;
    private final double percent;
}
