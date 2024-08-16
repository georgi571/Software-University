package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.repositories;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.workshops.Workshop;

public interface WorkshopRepository {

    void add(Workshop workshop);

    boolean remove(Workshop workshop);

    Workshop findByType(String type);
}
