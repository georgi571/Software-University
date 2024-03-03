package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAllEntities();

    void add(T entity);

}
