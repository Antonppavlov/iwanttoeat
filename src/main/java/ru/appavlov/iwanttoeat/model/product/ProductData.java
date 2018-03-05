package ru.appavlov.iwanttoeat.model.product;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product_data")
@EqualsAndHashCode(of = "id")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class ProductData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "water_g")
    private BigDecimal waterG;

    @Column(name = "proteins_g")
    private BigDecimal proteinsG;

    @Column(name = "fats_g")
    private BigDecimal fatsG;

    @Column(name = "carbohydrates_g")
    private BigDecimal carbohydratesG;

    @Column(name = "mono_and_disaccharides_g")
    private BigDecimal monoAndDisaccharidesG;

    @Column(name = "fiber_g")
    private BigDecimal fiberG;

    @Column(name = "starch_g")
    private BigDecimal starchG;

    @Column(name = "pectin_g")
    private BigDecimal pectinG;

    @Column(name = "organic_acids_g")
    private BigDecimal organicAcidsG;

    @Column(name = "ash_g")
    private BigDecimal ashG;

    @Column(name = "potassium_mg")
    private BigDecimal potassiumMg;

    @Column(name = "calcium_mg")
    private BigDecimal calciumMg;

    @Column(name = "magnesium_mg")
    private BigDecimal magnesiumMg;

    @Column(name = "sodium_mg")
    private BigDecimal sodiumMg;

    @Column(name = "phosphorus_mg")
    private BigDecimal phosphorusMg;

    @Column(name = "iron_g")
    private BigDecimal ironG;

    @Column(name = "iodine_mkg")
    private BigDecimal iodineMkg;

    @Column(name = "cobalt_mg")
    private BigDecimal cobaltMg;

    @Column(name = "manganese_mcg")
    private BigDecimal manganeseMcg;

    @Column(name = "copper_g")
    private BigDecimal copperG;

    @Column(name = "molybdenum_g")
    private BigDecimal molybdenumG;

    @Column(name = "fluorine_g")
    private BigDecimal fluorineG;

    @Column(name = "zinc_g")
    private BigDecimal zincG;

    @Column(name = "vitamin_a_retinol_mg")
    private BigDecimal vitaminARetinolMg;

    @Column(name = "vitamin_b_carotene_mg")
    private BigDecimal vitaminBCaroteneMg;

    @Column(name = "vitamin_c_ascorbic_acid_mg")
    private BigDecimal vitaminCAscorbicAcidMg;

    @Column(name = "vitamin_b1_thiamine_mg")
    private BigDecimal vitaminB1ThiamineMg;

    @Column(name = "vitamin_b2_riboflavin_mg")
    private BigDecimal vitaminB2RiboflavinMg;

    @Column(name = "vitamin_b9_folic_acid_g")
    private BigDecimal vitaminB9FolicAcidG;

    @Column(name = "vitamin_e_tocopherol_mg")
    private BigDecimal vitaminETocopherolMg;

    @Column(name = "vitamin_pp_niacin_mg")
    private BigDecimal vitaminPpNiacinMg;

    @Column(name = "calorie_calories")
    private BigDecimal calorieCalories;

//    @OneToOne
//    @JoinColumn
//    private Product product;
}
