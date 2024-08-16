package _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._01HighQualityStructure.dolphinarium.entities.dolphins;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.common.ExceptionMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Food;

public abstract class BaseDolphin implements Dolphin {
    private String name;
    private int energy;

    public BaseDolphin(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void jump() {
        this.setEnergy(this.getEnergy() - 10);
    }

    @Override
    public void eat(Food food) {
        this.energy += food.getCalories();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {
            energy = 0;
        }
        this.energy = energy;
    }
}
