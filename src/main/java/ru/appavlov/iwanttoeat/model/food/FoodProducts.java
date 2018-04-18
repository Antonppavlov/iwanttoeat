package ru.appavlov.iwanttoeat.model.food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.appavlov.iwanttoeat.model.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(catalog = "iwanttoeat", name = "food_products")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
public class FoodProducts {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "value")
    private BigDecimal value;


}


