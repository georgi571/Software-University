package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._01HighQualityStructure.christmasPastryShop.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAll();

    void add(T t);

}
