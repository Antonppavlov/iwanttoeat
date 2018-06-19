package ru.appavlov.iwanttoeat.model.food;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "food_name")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
public class FoodName {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    @Id
    private Long id;

    @Column(name = "name_ru", updatable = false)
    private String nameRu;

    @JsonIgnore
    @Column(name = "name_eng", updatable = false)
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
