package ru.appavlov.iwanttoeat.model.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "product")
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private ProductName name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private ProductType type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private ProductData data;

}


