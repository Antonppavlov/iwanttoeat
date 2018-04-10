package ru.appavlov.iwanttoeat.model.food;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;
import ru.appavlov.iwanttoeat.model.product.ProductData;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(catalog = "iwanttoeat", name = "food")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "food_name_id")
    private FoodName name;

    @OneToOne
    @JoinColumn(name = "food_type_id")
    private FoodType food_type;

    @OneToOne
    @JoinColumn(name = "food_subtype_id")
    private FoodSubtype subtype;

    @OneToOne
    @JoinColumn(name = "food_recipe_id")
    private FoodRecipe recipe;

    @OneToMany(mappedBy = "food")
    private List<FoodProducts> foodProducts;

    //TODO метод рабочий и подгоняет количество продуктов к нужным каллориям, но нужно срочно зарефакторить
    public CaloriesAndPFC calculateCaloriesFood(double caloriesPerFood) {
        double calorieIntake = 0.1;
        double proteinsIntake = 0.1;
        double fatsIntake = 0.1;
        double carbohydratesIntake = 0.1;

        for (FoodProducts product : foodProducts) {
            //TODO надо будет отключить
            //нужно попроавить в базе т.к. какое-то поле null некоректно
            double valueProducts = 0;
            if (product.getValue() != null) {
                //получаю вес продукта
                valueProducts = product.getValue().doubleValue();
            }

            ProductData data = product.getProduct().getData();

            if (data.getCalories() != null) {
                calorieIntake += data.getCalories().doubleValue() * (valueProducts / 100);
            }
            if (data.getProteins() != null) {
                proteinsIntake += data.getProteins().doubleValue() * (valueProducts / 100);
            }
            if (data.getFats() != null) {
                fatsIntake += data.getFats().doubleValue() * (valueProducts / 100);
            }
            if (data.getCarbohydrates() != null) {
                carbohydratesIntake += data.getCarbohydrates().doubleValue() * (valueProducts / 100);
            }

        }

        //теперь вычисляем coefficient на сколько раз надо поделить каллории
        double coefficient = caloriesPerFood / calorieIntake;

        for (FoodProducts product : foodProducts) {
            //TODO надо будет отключить
            //нужно попроавить в базе т.к. какое-то поле null некоректно

            if (product.getValue() != null) {
                product.setValue(BigDecimal.valueOf(product.getValue().doubleValue() * coefficient));
            }

            ProductData data = product.getProduct().getData();

            if (data.getCalories() != null) {
                data.setCalories(BigDecimal.valueOf(data.getCalories().doubleValue() * coefficient));
            }
            if (data.getProteins() != null) {
                data.setProteins(BigDecimal.valueOf(data.getProteins().doubleValue() * coefficient));
            }
            if (data.getFats() != null) {
                data.setFats(BigDecimal.valueOf(data.getFats().doubleValue() * coefficient));
            }
            if (data.getCarbohydrates() != null) {
                data.setCarbohydrates(BigDecimal.valueOf(data.getCarbohydrates().doubleValue() * coefficient));
            }

        }

        return new CaloriesAndPFC(
                (int) (calorieIntake * coefficient),
                (int) (proteinsIntake * coefficient),
                (int) (fatsIntake * coefficient),
                (int) (carbohydratesIntake * coefficient));
    }

}
