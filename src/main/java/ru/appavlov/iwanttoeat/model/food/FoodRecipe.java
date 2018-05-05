package ru.appavlov.iwanttoeat.model.food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "food_recipe")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
public class FoodRecipe {

    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "description_ru")
    private String descriptionRu;

    @JsonIgnore
    @Column(name = "description_eng")
    private String descriptionEng;

}

