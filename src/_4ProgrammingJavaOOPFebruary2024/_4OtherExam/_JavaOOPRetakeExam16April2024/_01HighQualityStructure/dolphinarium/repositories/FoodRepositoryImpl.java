package _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024._01HighQualityStructure.dolphinarium.repositories;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository{
    private Collection<Food> foods;

    public FoodRepositoryImpl() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        if (!this.foods.contains(food)) {
            this.foods.add(food);
        }
    }

    @Override
    public boolean remove(Food food) {
        if (this.foods.contains(food)) {
            this.foods.remove(food);
            return true;
        }
        return false;
    }

    @Override
    public Food findByType(String type) {
        for (Food food : this.foods) {
            if (food.getClass().getSimpleName().equals(type)) {
                return food;
            }
        }
        return null;
    }
}
