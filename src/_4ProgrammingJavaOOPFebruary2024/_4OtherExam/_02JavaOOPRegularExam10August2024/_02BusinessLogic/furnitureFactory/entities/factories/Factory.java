package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.factories;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024._02BusinessLogic.furnitureFactory.entities.workshops.Workshop;

import java.util.Collection;

public interface Factory {

    String getName();

    void addWorkshop(Workshop workshop);

    Collection<Workshop> getWorkshops();

    Collection<Workshop> getRemovedWorkshops();
}
