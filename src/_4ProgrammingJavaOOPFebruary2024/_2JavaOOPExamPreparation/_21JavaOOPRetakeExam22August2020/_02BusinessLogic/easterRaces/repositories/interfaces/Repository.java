package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {
    T getByName(String name);

    Collection<T> getAll();

    void add(T model);

    boolean remove(T model);
}
