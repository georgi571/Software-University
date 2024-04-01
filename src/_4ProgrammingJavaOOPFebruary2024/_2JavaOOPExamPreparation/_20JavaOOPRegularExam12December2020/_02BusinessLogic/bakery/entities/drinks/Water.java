package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._02BusinessLogic.bakery.entities.drinks;

public class Water extends BaseDrink {
    private static final double PRICE = 1.50;
    public Water(String name, int portion, String brand) {
        super(name, portion, PRICE, brand);
    }
}
