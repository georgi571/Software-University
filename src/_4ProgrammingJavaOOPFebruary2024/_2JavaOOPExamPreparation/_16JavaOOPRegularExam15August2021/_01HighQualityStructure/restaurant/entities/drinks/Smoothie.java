package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.drinks;

public class Smoothie extends BaseBeverage {
    private static final double PRICE = 4.50;
    public Smoothie(String name, int counter, String brand) {
        super(name, counter, PRICE, brand);
    }
}
