package ru.appavlov.iwanttoeat.service.menu;

import lombok.Getter;

public class Params {

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
