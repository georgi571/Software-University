package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._02BusinessLogic.christmasPastryShop.repositories.interfaces;

public interface DelicacyRepository<T> extends Repository<T> {
    T getByName(String name);
}
