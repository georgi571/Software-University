package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.drivers;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
