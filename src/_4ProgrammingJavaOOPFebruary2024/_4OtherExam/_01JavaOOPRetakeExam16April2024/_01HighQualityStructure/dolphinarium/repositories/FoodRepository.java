package _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._01HighQualityStructure.dolphinarium.repositories;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._01JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Food;

//TODO Implement all methods
public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
