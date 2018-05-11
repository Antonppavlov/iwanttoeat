package ru.appavlov.iwanttoeat.repository.food;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.food.FoodSubtype;

import java.util.List;

@Repository
public interface FoodSubtypeRepository extends JpaRepository<FoodSubtype, Long> {

    List<FoodSubtype> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu);

    Page<FoodSubtype> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu, Pageable pageable);

}

