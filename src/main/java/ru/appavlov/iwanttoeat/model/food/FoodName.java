package ru.appavlov.iwanttoeat.model.food;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "food_name")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class FoodName {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_eng")
    private String nameEng;

    public FoodName() {
    }

    public FoodName(String nameRu, String nameEng) {
        this.nameRu = nameRu;
        this.nameEng = nameEng;
    }


    public FoodName(Long id, String nameRu, String nameEng) {
        this.id = id;
        this.nameRu = nameRu;
        this.nameEng = nameEng;
    }

}
