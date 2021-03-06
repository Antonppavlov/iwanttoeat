package ru.appavlov.iwanttoeat.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "product_name")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class ProductName {
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    @Id
    private Long id;

    @Column(name = "name_ru", updatable = false)
    private String nameRu;

    @JsonIgnore
    @Column(name = "name_eng", updatable = false)
    private String nameEng;

    @Override
    public String toString() {
        return nameRu;
    }
}


