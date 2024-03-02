package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._01HighQualityStructure.catHouse.entities.houses;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._01HighQualityStructure.catHouse.entities.cat.Cat;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._01HighQualityStructure.catHouse.entities.toys.Toy;

import java.util.Collection;

public interface House {
    int sumSoftness();

    void addCat(Cat cat);

    void removeCat(Cat cat);

    void buyToy(Toy toy);

    void feeding();

    String getStatistics();

    String getName();

    void setName(String name);

    Collection<Cat> getCats();

    Collection<Toy> getToys();
}
