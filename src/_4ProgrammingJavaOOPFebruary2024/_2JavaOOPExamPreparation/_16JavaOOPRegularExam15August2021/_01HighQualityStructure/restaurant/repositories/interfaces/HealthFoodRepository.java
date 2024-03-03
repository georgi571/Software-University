package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.repositories.interfaces;

public interface HealthFoodRepository<T> extends Repository<T> {
    T foodByName(String name);
}
