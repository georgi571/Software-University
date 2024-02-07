package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._05Restaurant.restaurant;

import java.math.BigDecimal;

public class Food extends Product {
    private double grams;

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }
}
