package ru.appavlov.iwanttoeat.service.dao;

import ru.appavlov.iwanttoeat.model.food.Food;

import java.util.List;

public interface MenuService {
    List<Food> getOneDayMenu(int calories);
}
