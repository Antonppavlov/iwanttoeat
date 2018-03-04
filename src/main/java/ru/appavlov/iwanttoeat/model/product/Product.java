package ru.appavlov.iwanttoeat.model.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(catalog = "product")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne(mappedBy = "product_name")
    @Column(name = "product_name_id")
    private Long productNameId;

    @OneToOne(mappedBy = "product_type")
    @Column(name = "product_type_id")
    private Long productTypeId;

    @OneToOne(mappedBy = "product_data")
    @Column(name = "product_data_id")
    private Long productDataId;

}


