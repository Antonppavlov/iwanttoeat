package ru.appavlov.iwanttoeat.model.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(catalog = "iwanttoeat", name = "product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name.getNameRu() +
                ", type=" + type.getNameRu() +
                ", data=" + data.toString() +
                '}';
    }
}


