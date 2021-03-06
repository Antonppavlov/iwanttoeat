package ru.appavlov.iwanttoeat.repository.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.product.ProductType;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    List<ProductType> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu);

    Page<ProductType> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu, Pageable pageable);

}


