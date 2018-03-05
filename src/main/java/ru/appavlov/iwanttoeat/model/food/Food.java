package ru.appavlov.iwanttoeat.model.food;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "food")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private FoodName name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private FoodType type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private FoodSubtype subtype;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private FoodRecipe recipe;

}
