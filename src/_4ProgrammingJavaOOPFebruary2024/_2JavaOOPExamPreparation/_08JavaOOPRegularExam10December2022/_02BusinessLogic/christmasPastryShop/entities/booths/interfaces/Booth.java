package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._02BusinessLogic.christmasPastryShop.entities.booths.interfaces;

public interface Booth {
    int getBoothNumber();

    int getCapacity();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    double getBill();

    void clear();
}
