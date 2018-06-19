package ru.appavlov.iwanttoeat.model.food;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "iwanttoeat", name = "food")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Food implements Cloneable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "food_name_id", updatable = false)
    private FoodName name;

    @OneToOne
    @JoinColumn(name = "food_type_id", updatable = false)
    private FoodType foodType;

    @OneToOne
    @JoinColumn(name = "food_subtype_id", updatable = false)
    private FoodSubtype foodSubType;

    @OneToOne
    @JoinColumn(name = "food_recipe_id", updatable = false)
    private FoodRecipe recipe;

    @OneToMany(mappedBy = "food")
    private List<FoodProducts> foodProducts;

    @Override
    public Food clone() throws CloneNotSupportedException {
        return (Food) super.clone();
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name=" + name.getNameRu() +
                ", foodType=" + foodType.getNameRu() +
                ", foodSubType=" + foodSubType.getNameRu() +
                '}';
    }
}
