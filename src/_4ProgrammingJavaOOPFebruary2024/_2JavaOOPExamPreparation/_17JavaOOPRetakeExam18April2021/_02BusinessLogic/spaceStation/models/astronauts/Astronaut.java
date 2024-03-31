package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
