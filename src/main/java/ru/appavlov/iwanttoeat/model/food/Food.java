package ru.appavlov.iwanttoeat.model.food;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(catalog = "food")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne(mappedBy = "food_name")
    @Column(name = "food_name_id")
    private Long foodNameId;

    @OneToOne(mappedBy = "food_type")
    @Column(name = "food_type_id")
    private Long foodTypeId;

    @OneToOne(mappedBy = "food_subtype")
    @Column(name = "food_subtype_id")
    private Long foodSubtypeId;

    @OneToOne(mappedBy = "food_recipe")
    @Column(name = "food_recipe_id")
    private Long foodRecipeId;

}
