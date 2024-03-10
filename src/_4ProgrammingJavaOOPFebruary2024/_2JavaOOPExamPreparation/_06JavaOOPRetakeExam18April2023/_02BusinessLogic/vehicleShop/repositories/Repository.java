package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getWorkers();

    void add(T model);

    boolean remove(T model);

    T findByName(String name);
}
