package ru.appavlov.iwanttoeat.model.menu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HumanParam {
    private boolean gender;
    private int age;
    private int height;
    private int weight;
    private int activity;
    private int target;

    public HumanParam() {
    }

    public HumanParam(boolean gender, int age, int height, int weight, int activity, int target) {
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.activity = activity;
        this.target = target;
    }
}
