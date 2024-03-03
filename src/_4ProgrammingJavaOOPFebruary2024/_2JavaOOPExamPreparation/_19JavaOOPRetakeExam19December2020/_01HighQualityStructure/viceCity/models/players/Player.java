package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.players;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.guns.Gun;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
