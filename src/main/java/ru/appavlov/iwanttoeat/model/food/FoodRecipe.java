package ru.appavlov.iwanttoeat.model.food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "food_recipe")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class FoodRecipe {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "description_ru")
    private String descriptionRu;

    @JsonIgnore
    @Column(name = "description_eng")
    private String descriptionEng;

}

