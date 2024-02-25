package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.services;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.robot.Robot;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.supplements.Supplement;

import java.util.Collection;

public interface Service {
    String getName();

    void setName(String name);

    Collection<Robot> getRobots();

    Collection<Supplement> getSupplements();

    void addRobot(Robot robot);

    void removeRobot(Robot robot);

    void addSupplement(Supplement supplement);

    void feeding();

    int sumHardness();

    String getStatistics();
}
