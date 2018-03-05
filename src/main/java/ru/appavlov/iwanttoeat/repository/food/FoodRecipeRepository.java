package ru.appavlov.iwanttoeat.repository.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.food.FoodRecipe;

@Repository
public interface FoodRecipeRepository extends JpaRepository<FoodRecipe, Long> {


}

