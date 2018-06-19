package ru.appavlov.iwanttoeat.service.menu;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.appavlov.iwanttoeat.model.menu.CPFC;
import ru.appavlov.iwanttoeat.model.menu.HumanParam;

@Service
public class CaloriesCalculateService {

    public CPFC caloriesAndPFC(HumanParam humanParam) {
        return caloriesAndPFC(
                humanParam.isGender(),
                humanParam.getAge(),
                humanParam.getHeight(),
                humanParam.getWeight(),
                humanParam.getActivity(),
                humanParam.getTarget()
        );
    }

    public CPFC caloriesAndPFC(boolean gender, int age, int height, int weight, int activity, int target) {
        short percent100 = 100;

        short proteinsPercent = 27;
        short fatsPercent = 23;
        short carbohydratesPercent = 50;

        short caloriesInProteins = 4;
        short caloriesInFats = 9;
        short caloriesInCarbohydrates = 4;

        int calories = calculationOfCalorieAllowanceTarget(gender, age, height, weight, activity, target);

        int proteins = ((calories / percent100) * proteinsPercent) / caloriesInProteins;
        int fats = ((calories / percent100) * fatsPercent) / caloriesInFats;
        int carbohydrates = ((calories / percent100) * carbohydratesPercent) / caloriesInCarbohydrates;

        return new CPFC(calories, proteins, fats, carbohydrates);
    }

    private int calculationOfCalorieAllowanceTarget(boolean gender, int age, int height, int weight, int activity, int target) {
        int minCalorie = 1450;
        double targetValue = GoalOfProperNutrition.values()[target].getValue();
        double calorieTargetCalculation = calculationOfCalorieAllowanceActivity(gender, age, height, weight, activity) + targetValue;

        if (calorieTargetCalculation < minCalorie) {
            calorieTargetCalculation = minCalorie;
        }

        return (int) calorieTargetCalculation;
    }

    private double calculationOfCalorieAllowanceActivity(boolean gender, int age, int height, int currentWeight, int activity) {
        double physicalActivityValue = PhysicalActivity.values()[activity].getValue();
        double calorieNormalCalculation = formulaCaloriesNormalCalculation(gender, age, height, currentWeight);
        return calorieNormalCalculation * physicalActivityValue;
    }

    private double formulaCaloriesNormalCalculation(boolean gender, int age, int height, int currentWeight) {
        double genderNeedCalories;

        if (gender) {
            genderNeedCalories = 66.47 + 13.75 * currentWeight + 5.0 * height - 6.74 * age;
        } else {
            genderNeedCalories = 655.1 + 9.6 * currentWeight + 1.85 * height - 4.68 * age;
        }

        return genderNeedCalories;
    }


    @Getter
    public enum PhysicalActivity {

        MINIMUM_LOADS(1.2, "Минимальные нагрузки (сидячая работа)"),
        LITTLE_DAILY_ACTIVITY(1.375, "Немного дневной активности и легкие упражнения 1-3 раза в неделю"),
        MODERATE_WORK(1.4625, "Тренировки 4-5 раз в неделю (или работа средней тяжести)"),
        INTENSIVE_WORKOUTS(1.550, "Интенсивные тренировки 4-5 раз в неделю"),
        DAILY_WORKOUTS(1.6375, "Ежедневные тренировки"),
        DAILY_WORKOUTS_2_TO_DAY(1.725, "Ежедневные интенсивные тренировки или тренировки 2 раза в день"),
        HARD_DAILY_WORKOUTS_2_TO_DAY(1.9, "Тяжелая физическая работа или интенсивные тренировки 2 раза в день"),;

        private double value;
        private String nameActivity;

        PhysicalActivity(double value, String nameActivity) {
            this.value = value;
            this.nameActivity = nameActivity;
        }
    }

    @Getter
    public enum GoalOfProperNutrition {
        LOSE_WEIGHT(-500),
        NOT_CHANGE_WEIGHT(0),
        PUMP_UP_MUSCLES(500),;

        private double value;

        GoalOfProperNutrition(double value) {
            this.value = value;
        }
    }
}

