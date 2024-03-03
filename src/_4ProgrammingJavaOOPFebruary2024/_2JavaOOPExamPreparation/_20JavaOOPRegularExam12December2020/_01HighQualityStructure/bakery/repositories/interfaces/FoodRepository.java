package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories.interfaces;

public interface FoodRepository<T> extends Repository<T> {
    T getByName(String name);
}
