package ru.appavlov.iwanttoeat.repository.food;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.food.FoodName;

@Repository
public interface FoodNameRepository extends JpaRepository<FoodName, Long> {


}