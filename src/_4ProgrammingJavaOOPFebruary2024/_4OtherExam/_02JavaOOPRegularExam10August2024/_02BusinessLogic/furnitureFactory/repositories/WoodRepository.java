package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.repositories;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.wood.Wood;

public interface WoodRepository {

    void add(Wood wood);

    boolean remove(Wood wood);

    Wood findByType(String type);
}
