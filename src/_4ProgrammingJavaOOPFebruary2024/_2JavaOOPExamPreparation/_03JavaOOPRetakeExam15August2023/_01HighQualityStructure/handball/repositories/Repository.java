package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.entities.equipment.Equipment;

public interface Repository {
    void add(Equipment equipment);
    boolean remove(Equipment equipment);
    Equipment findByType(String type);
}
