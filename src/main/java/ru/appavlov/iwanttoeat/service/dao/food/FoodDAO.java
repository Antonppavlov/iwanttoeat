package ru.appavlov.iwanttoeat.service.dao.food;

import ru.appavlov.iwanttoeat.model.food.Food;
import ru.appavlov.iwanttoeat.service.dao.GeneralDAO;

public interface FoodDAO extends GeneralDAO<Food> {

    Food getRandomFoodWhereTypeId(long typeId);

    Food getRandomFoodWhereSubTypeId(long typeId);
}
