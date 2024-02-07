package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._05Restaurant.restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {
    private static final double SALMON_GRAMS = 3;
    public Salmon(String name, BigDecimal price, double grams) {
        super(name, price, grams);
        super.setGrams(SALMON_GRAMS);
    }
}
