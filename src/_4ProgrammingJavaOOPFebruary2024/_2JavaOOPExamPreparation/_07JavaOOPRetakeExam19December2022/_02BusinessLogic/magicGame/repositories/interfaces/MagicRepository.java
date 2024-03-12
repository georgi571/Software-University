package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.repositories.interfaces;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.magics.Magic;

import java.util.Collection;

public interface MagicRepository<T> {
    Collection<T> getData();

    void addMagic(Magic model);

    boolean removeMagic(Magic model);

    T findByName(String name);
}
