package ru.appavlov.iwanttoeat.model.food;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(catalog = "food_subtype")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class FoodSubtype {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_eng")
    private String nameEng;
}

