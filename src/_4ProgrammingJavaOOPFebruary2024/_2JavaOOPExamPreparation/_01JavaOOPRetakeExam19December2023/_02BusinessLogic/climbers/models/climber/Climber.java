package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climber;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.roster.Roster;

public interface Climber {
    String getName();

    double getStrength();

    boolean canClimb();

    Roster getRoster();


    void climb();
}
