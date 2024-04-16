package _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.dolphins;

//TODO Implement all methods


import _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Food;

public interface Dolphin {
    String getName();
    int getEnergy();

    void jump();

    void eat(Food food);
}
