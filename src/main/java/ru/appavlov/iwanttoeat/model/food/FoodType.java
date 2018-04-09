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
@Table(catalog = "iwanttoeat", name = "food_type")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class FoodType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name_ru")
    private String nameRu;

    @JsonIgnore
    @Column(name = "name_eng")
    private String nameEng;

}

