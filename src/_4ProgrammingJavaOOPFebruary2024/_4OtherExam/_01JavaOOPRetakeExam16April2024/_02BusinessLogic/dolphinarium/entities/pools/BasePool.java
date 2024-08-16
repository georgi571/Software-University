package _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.pools;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.common.ExceptionMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.dolphins.Dolphin;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BasePool implements Pool{
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Dolphin> dolphins;

    public BasePool(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.dolphins = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public Collection<Dolphin> getDolphins() {
        return Collections.unmodifiableCollection(this.dolphins);
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public void addDolphin(Dolphin dolphin) {
        if (this.dolphins.size() >= this.capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        if (dolphin.getEnergy() <= 0) {
            throw new IllegalStateException(ExceptionMessages.DOLPHIN_ENERGY_BELOW_OR_EQUAL_ZERO);
        }
        this.dolphins.add(dolphin);
    }

    @Override
    public void removeDolphin(Dolphin dolphin) {
        this.dolphins.remove(dolphin);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.POOL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
