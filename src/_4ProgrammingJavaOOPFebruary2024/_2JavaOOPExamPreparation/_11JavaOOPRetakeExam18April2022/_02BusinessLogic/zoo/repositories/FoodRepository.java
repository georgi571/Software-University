package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022._02BusinessLogic.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
