package ru.appavlov.iwanttoeat.model.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(catalog = "iwanttoeat", name = "product_data")
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
    @JsonIgnore
    @Column(name = "water_g")
    private BigDecimal waterG;

    @Column(name = "proteins_g")
    private BigDecimal proteinsG;

    @Column(name = "fats_g")
    private BigDecimal fatsG;

    @Column(name = "carbohydrates_g")
    private BigDecimal carbohydratesG;

    @JsonIgnore
    @Column(name = "mono_and_disaccharides_g")
    private BigDecimal monoAndDisaccharidesG;

    @JsonIgnore
    @Column(name = "fiber_g")
    private BigDecimal fiberG;

    @JsonIgnore
    @Column(name = "starch_g")
    private BigDecimal starchG;

    @JsonIgnore
    @Column(name = "pectin_g")
    private BigDecimal pectinG;

    @JsonIgnore
    @Column(name = "organic_acids_g")
    private BigDecimal organicAcidsG;

    @JsonIgnore
    @Column(name = "ash_g")
    private BigDecimal ashG;

    @JsonIgnore
    @Column(name = "potassium_mg")
    private BigDecimal potassiumMg;

    @JsonIgnore
    @Column(name = "calcium_mg")
    private BigDecimal calciumMg;

    @JsonIgnore
    @Column(name = "magnesium_mg")
    private BigDecimal magnesiumMg;

    @JsonIgnore
    @Column(name = "sodium_mg")
    private BigDecimal sodiumMg;

    @JsonIgnore
    @Column(name = "phosphorus_mg")
    private BigDecimal phosphorusMg;

    @JsonIgnore
    @Column(name = "iron_g")
    private BigDecimal ironG;

    @JsonIgnore
    @Column(name = "iodine_mkg")
    private BigDecimal iodineMkg;

    @JsonIgnore
    @Column(name = "cobalt_mg")
    private BigDecimal cobaltMg;

    @JsonIgnore
    @Column(name = "manganese_mcg")
    private BigDecimal manganeseMcg;

    @JsonIgnore
    @Column(name = "copper_g")
    private BigDecimal copperG;

    @JsonIgnore
    @Column(name = "molybdenum_g")
    private BigDecimal molybdenumG;

    @JsonIgnore
    @Column(name = "fluorine_g")
    private BigDecimal fluorineG;

    @JsonIgnore
    @Column(name = "zinc_g")
    private BigDecimal zincG;

    @JsonIgnore
    @Column(name = "vitamin_a_retinol_mg")
    private BigDecimal vitaminARetinolMg;

    @JsonIgnore
    @Column(name = "vitamin_b_carotene_mg")
    private BigDecimal vitaminBCaroteneMg;

    @JsonIgnore
    @Column(name = "vitamin_c_ascorbic_acid_mg")
    private BigDecimal vitaminCAscorbicAcidMg;

    @JsonIgnore
    @Column(name = "vitamin_b1_thiamine_mg")
    private BigDecimal vitaminB1ThiamineMg;

    @JsonIgnore
    @Column(name = "vitamin_b2_riboflavin_mg")
    private BigDecimal vitaminB2RiboflavinMg;

    @JsonIgnore
    @Column(name = "vitamin_b9_folic_acid_g")
    private BigDecimal vitaminB9FolicAcidG;

    @JsonIgnore
    @Column(name = "vitamin_e_tocopherol_mg")
    private BigDecimal vitaminETocopherolMg;

    @JsonIgnore
    @Column(name = "vitamin_pp_niacin_mg")
    private BigDecimal vitaminPpNiacinMg;

    @Column(name = "calorie_calories")
    private BigDecimal calorieCalories;
}
