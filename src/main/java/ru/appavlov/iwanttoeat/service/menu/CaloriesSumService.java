package ru.appavlov.iwanttoeat.service.menu;

import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.menu.CPFC;

@Service
public class CaloriesSumService {

    public CPFC sumAllCaloriesAndPFC(CPFC... arrayCPFC) {
        int allCalorie = 0;
        int allProteins = 0;
        int allFats = 0;
        int allCarbohydrates = 0;

        for (CPFC CPFCFood : arrayCPFC) {
            allCalorie += CPFCFood.getCalories();
            allProteins += CPFCFood.getProteins();
            allFats += CPFCFood.getFats();
            allCarbohydrates += CPFCFood.getCarbohydrates();
        }

        return new CPFC(
                allCalorie,
                allProteins,
                allFats,
                allCarbohydrates
        );
    }
}
