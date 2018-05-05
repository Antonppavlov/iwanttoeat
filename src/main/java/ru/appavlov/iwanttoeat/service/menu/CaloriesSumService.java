package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.menu.CaloriesAndPFC;

@Service
public class CaloriesSumService {

    public CaloriesAndPFC sumAllCaloriesAndPFC(CaloriesAndPFC... caloriesAndPFCs) {
        int allCalorie = 0;
        int allProteins = 0;
        int allFats = 0;
        int allCarbohydrates = 0;

        for (CaloriesAndPFC caloriesAndPFCFood : caloriesAndPFCs) {
            allCalorie += caloriesAndPFCFood.getCalorie();
            allProteins += caloriesAndPFCFood.getProteins();
            allFats += caloriesAndPFCFood.getFats();
            allCarbohydrates += caloriesAndPFCFood.getCarbohydrates();
        }

        return new CaloriesAndPFC(
                allCalorie,
                allProteins,
                allFats,
                allCarbohydrates
        );
    }
}
