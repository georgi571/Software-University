package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.tables.interfaces;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.drinks.interfaces.Beverages;

public interface Table {
    int getTableNumber();

    int getSize();

    int numberOfPeople();

    double pricePerPerson();

    boolean isReservedTable();

    double allPeople();

    void reserve(int numberOfPeople);

    void orderHealthy(HealthyFood food);

    void orderBeverages(Beverages beverages);

    double bill();

    void clear();

    String tableInformation();
}
