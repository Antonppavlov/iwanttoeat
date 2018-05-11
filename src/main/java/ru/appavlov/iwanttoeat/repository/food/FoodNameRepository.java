package ru.appavlov.iwanttoeat.repository.food;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.food.FoodName;

import java.util.List;

@Repository
public interface FoodNameRepository extends JpaRepository<FoodName, Long> {

    List<FoodName> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu);

    Page<FoodName> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu, Pageable pageable);
}
