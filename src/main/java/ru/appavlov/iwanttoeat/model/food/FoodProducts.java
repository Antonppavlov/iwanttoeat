package ru.appavlov.iwanttoeat.model.food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.appavlov.iwanttoeat.model.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(catalog = "iwanttoeat", name = "food_products")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class FoodProducts {
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    @Id
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", updatable = false)
    private Food food;

    @OneToOne
    @JoinColumn(name = "product_id", updatable = false)
    private Product product;

    @Column(name = "value", updatable = false)
    private BigDecimal value;

    @Override
    public String toString() {
        return "FoodProducts{" +
                "id=" + id +
                ", product=" + product.getName().getNameRu() +
                ", value=" + value.doubleValue() +
                ", calories=" + product.getData().getCalories() +
                ", proteins=" + product.getData().getProteins() +
                ", fats=" + product.getData().getFats() +
                ", carbohydrates=" + product.getData().getCarbohydrates() +
                '}';
    }
}


