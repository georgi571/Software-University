package _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024._01HighQualityStructure.dolphinarium.entities.pools;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.dolphins.Dolphin;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024._02BusinessLogic.dolphinarium.entities.foods.Food;

import java.util.Collection;
//TODO Implement all methods

public interface Pool {
    String getName();

    int getCapacity();

    Collection<Dolphin> getDolphins();

    Collection<Food> getFoods();


    void addDolphin(Dolphin dolphin);

    void removeDolphin(Dolphin dolphin);

    void addFood(Food food);

}
