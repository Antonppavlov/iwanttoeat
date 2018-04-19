package ru.appavlov.iwanttoeat.repository.food;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.food.FoodType;

import java.util.List;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

    List<FoodType> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu);

}

