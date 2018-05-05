package ru.appavlov.iwanttoeat.model.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(catalog = "iwanttoeat", name = "product_data")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
public class ProductData {

    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JsonIgnore
    @Column(name = "water_g", updatable = false)
    private BigDecimal waterG;

    @Column(name = "proteins_g", updatable = false)
    private BigDecimal proteins;

    @Column(name = "fats_g", updatable = false)
    private BigDecimal fats;

    @Column(name = "carbohydrates_g", updatable = false)
    private BigDecimal carbohydrates;

    @JsonIgnore
    @Column(name = "mono_and_disaccharides_g", updatable = false)
    private BigDecimal monoAndDisaccharidesG;

    @JsonIgnore
    @Column(name = "fiber_g", updatable = false)
    private BigDecimal fiberG;

    @JsonIgnore
    @Column(name = "starch_g", updatable = false)
    private BigDecimal starchG;

    @JsonIgnore
    @Column(name = "pectin_g", updatable = false)
    private BigDecimal pectinG;

    @JsonIgnore
    @Column(name = "organic_acids_g", updatable = false)
    private BigDecimal organicAcidsG;

    @JsonIgnore
    @Column(name = "ash_g", updatable = false)
    private BigDecimal ashG;

    @JsonIgnore
    @Column(name = "potassium_mg", updatable = false)
    private BigDecimal potassiumMg;

    @JsonIgnore
    @Column(name = "calcium_mg", updatable = false)
    private BigDecimal calciumMg;

    @JsonIgnore
    @Column(name = "magnesium_mg", updatable = false)
    private BigDecimal magnesiumMg;

    @JsonIgnore
    @Column(name = "sodium_mg", updatable = false)
    private BigDecimal sodiumMg;

    @JsonIgnore
    @Column(name = "phosphorus_mg", updatable = false)
    private BigDecimal phosphorusMg;

    @JsonIgnore
    @Column(name = "iron_g", updatable = false)
    private BigDecimal ironG;

    @JsonIgnore
    @Column(name = "iodine_mkg", updatable = false)
    private BigDecimal iodineMkg;

    @JsonIgnore
    @Column(name = "cobalt_mg", updatable = false)
    private BigDecimal cobaltMg;

    @JsonIgnore
    @Column(name = "manganese_mcg", updatable = false)
    private BigDecimal manganeseMcg;

    @JsonIgnore
    @Column(name = "copper_g", updatable = false)
    private BigDecimal copperG;

    @JsonIgnore
    @Column(name = "molybdenum_g", updatable = false)
    private BigDecimal molybdenumG;

    @JsonIgnore
    @Column(name = "fluorine_g", updatable = false)
    private BigDecimal fluorineG;

    @JsonIgnore
    @Column(name = "zinc_g", updatable = false)
    private BigDecimal zincG;

    @JsonIgnore
    @Column(name = "vitamin_a_retinol_mg", updatable = false)
    private BigDecimal vitaminARetinolMg;

    @JsonIgnore
    @Column(name = "vitamin_b_carotene_mg", updatable = false)
    private BigDecimal vitaminBCaroteneMg;

    @JsonIgnore
    @Column(name = "vitamin_c_ascorbic_acid_mg", updatable = false)
    private BigDecimal vitaminCAscorbicAcidMg;

    @JsonIgnore
    @Column(name = "vitamin_b1_thiamine_mg", updatable = false)
    private BigDecimal vitaminB1ThiamineMg;

    @JsonIgnore
    @Column(name = "vitamin_b2_riboflavin_mg", updatable = false)
    private BigDecimal vitaminB2RiboflavinMg;

    @JsonIgnore
    @Column(name = "vitamin_b9_folic_acid_g", updatable = false)
    private BigDecimal vitaminB9FolicAcidG;

    @JsonIgnore
    @Column(name = "vitamin_e_tocopherol_mg", updatable = false)
    private BigDecimal vitaminETocopherolMg;

    @JsonIgnore
    @Column(name = "vitamin_pp_niacin_mg", updatable = false)
    private BigDecimal vitaminPpNiacinMg;

    @Column(name = "calorie_calories", updatable = false)
    private BigDecimal calories;
}
