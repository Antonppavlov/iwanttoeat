package ru.appavlov.iwanttoeat.model.food;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "food")
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

    @OneToOne
    @JoinColumn(name = "food_name_id")
    private FoodName name;

    @OneToOne
    @JoinColumn(name = "food_type_id")
    private FoodType food_type;

    @OneToOne
    @JoinColumn(name = "food_subtype_id")
    private FoodSubtype subtype;

    @OneToOne
    @JoinColumn(name = "food_recipe_id")
    private FoodRecipe recipe;

}
