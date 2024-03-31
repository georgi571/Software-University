package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._02BusinessLogic.restaurant.entities.drinks;

public class Fresh extends BaseBeverage {
    private static final double PRICE = 3.50;
    public Fresh(String name, int counter, String brand) {
        super(name, counter, PRICE, brand);
    }
}
