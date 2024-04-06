package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024._01HighQualityStructure.restaurant.repositories;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getCollection();

    void add(T entity);

    boolean remove(T entity);

    T byName(String name);
}
