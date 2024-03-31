package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getModels();

    void add(T model);

    boolean remove(T model);

    T findByName(String name);
}
