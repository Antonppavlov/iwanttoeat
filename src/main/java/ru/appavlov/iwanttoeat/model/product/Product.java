package ru.appavlov.iwanttoeat.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
public class Product {

    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_name_id", updatable = false)
    private ProductName name;

    @OneToOne
    @JoinColumn(name = "product_type_id", updatable = false)
    private ProductType type;

    @OneToOne
    @JoinColumn(name = "product_data_id", updatable = false)
    private ProductData data;


}


