package ru.appavlov.iwanttoeat.model.menu;

import lombok.Data;

@Data
public class FoodTypeIdAndPercentFood {
    private final int typeId;
    private final double percent;
}
