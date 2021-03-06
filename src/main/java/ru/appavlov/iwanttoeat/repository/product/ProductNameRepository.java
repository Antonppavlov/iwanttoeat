package ru.appavlov.iwanttoeat.repository.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.product.ProductName;

import java.util.List;

@Repository
public interface ProductNameRepository extends JpaRepository<ProductName, Long> {

    List<ProductName> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu);

    Page<ProductName> findByNameRuContainingIgnoreCaseOrderByNameRu(String nameRu, Pageable pageable);

}


