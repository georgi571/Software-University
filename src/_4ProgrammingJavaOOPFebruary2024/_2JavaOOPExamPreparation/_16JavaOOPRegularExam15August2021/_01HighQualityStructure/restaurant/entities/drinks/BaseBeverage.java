package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.drinks;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.drinks.interfaces.Beverages;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.common.ExceptionMessages.*;

public abstract class BaseBeverage implements Beverages {
    private String name;
    private int counter;
    private double price;
    private String brand;

    public BaseBeverage(String name, int counter, double price, String brand) {
        this.setName(name);
        this.setCounter(counter);
        this.setPrice(price);
        this.setBrand(brand);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public void setCounter(int counter) {
        if (counter <= 0) {
            throw new IllegalArgumentException(INVALID_COUNTER);
        }
        this.counter = counter;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }
}
