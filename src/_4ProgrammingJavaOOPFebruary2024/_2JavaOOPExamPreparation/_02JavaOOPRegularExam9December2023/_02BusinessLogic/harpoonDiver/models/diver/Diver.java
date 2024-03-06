package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.diver;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._02BusinessLogic.harpoonDiver.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();

    double getOxygen();

    boolean canDive();

    SeaCatch getSeaCatch();

    void shoot();
}
