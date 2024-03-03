package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories.interfaces;

public interface TableRepository<T> extends Repository<T> {
    T byNumber(int number);
}
