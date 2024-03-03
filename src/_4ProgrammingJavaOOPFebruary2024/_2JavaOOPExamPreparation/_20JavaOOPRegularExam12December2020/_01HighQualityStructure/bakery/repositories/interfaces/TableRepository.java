package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories.interfaces;

public interface TableRepository<T> extends Repository<T> {
    T getByNumber(int number);
}
