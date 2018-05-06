package ru.appavlov.iwanttoeat.repository.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.food.Food;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByFoodTypeId(long foodType);

    List<Food> findByFoodSubTypeId(long foodType);
}