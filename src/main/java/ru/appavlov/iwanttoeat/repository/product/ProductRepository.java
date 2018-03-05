package ru.appavlov.iwanttoeat.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.appavlov.iwanttoeat.model.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}


