package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._02BusinessLogic.restaurant.entities.healthyFoods;

public class Salad extends Food {
    private static final double PORTION = 150;
    public Salad(String name, double price) {
        super(name, PORTION, price);
    }
}
