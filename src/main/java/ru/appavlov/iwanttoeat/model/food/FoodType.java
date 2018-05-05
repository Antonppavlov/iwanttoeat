package ru.appavlov.iwanttoeat.model.food;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "food_type")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
public class FoodType {

    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name_ru", updatable = false)
    private String nameRu;

    @JsonIgnore
    @Column(name = "name_eng", updatable = false)
    private String nameEng;

}

