package ru.appavlov.iwanttoeat.repository.food;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.food.FoodType;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

}

