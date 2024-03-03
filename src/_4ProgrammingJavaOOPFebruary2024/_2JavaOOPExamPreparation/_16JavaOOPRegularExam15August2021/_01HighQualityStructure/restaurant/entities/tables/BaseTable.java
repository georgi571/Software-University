package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.tables;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.drinks.interfaces.Beverages;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.tables.interfaces.Table;

import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.pricePerPerson * numberOfPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        if (numberOfPeople > 0) {
            this.isReservedTable = true;
        }
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double bill = 0;
        for (HealthyFood food : this.healthyFood) {
            bill += food.getPrice();
        }
        for (Beverages beverage : this.beverages) {
            bill += beverage.getPrice();
        }
        return bill * numberOfPeople;
    }

    @Override
    public void clear() {
        this.beverages.clear();
        this.healthyFood.clear();
        this.pricePerPerson = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Table - %d", this.number)).append(System.lineSeparator());
        info.append(String.format("Size - %d", this.size)).append(System.lineSeparator());
        info.append(String.format("Type - %s", this.getClass().getSimpleName())).append(System.lineSeparator());
        info.append(String.format("All price  - %.2f", this.pricePerPerson)).append(System.lineSeparator());
        return null;
    }
}
