package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._01HighQualityStructure.catHouse.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021._01HighQualityStructure.catHouse.entities.toys.Toy;

public interface Repository {

    void buyToy(Toy toy);

    boolean removeToy(Toy toy);

    Toy findFirst(String type);
}
