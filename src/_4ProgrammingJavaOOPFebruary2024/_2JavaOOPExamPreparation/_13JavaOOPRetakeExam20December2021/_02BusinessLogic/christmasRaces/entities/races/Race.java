package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._02BusinessLogic.christmasRaces.entities.races;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._02BusinessLogic.christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
