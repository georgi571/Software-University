package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._01HighQualityStructure.zoo.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._01HighQualityStructure.zoo.entities.foods.Food;

import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository {
    private Collection<Food> foods;
    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        if (foods.contains(food)) {
            foods.remove(food);
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
