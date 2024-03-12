package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.magicians;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.magics.Magic;

public interface Magician {
    String getUsername();

    int getHealth();

    int getProtection();

    Magic getMagic();

    boolean isAlive();

    void takeDamage(int points);
}
