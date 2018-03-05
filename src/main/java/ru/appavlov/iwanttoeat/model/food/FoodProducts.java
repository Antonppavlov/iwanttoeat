package ru.appavlov.iwanttoeat.model.food;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "food_products")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class FoodProducts {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    //    @OneToOne(mappedBy = "food")
    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "value")
    private BigDecimal value;

}


