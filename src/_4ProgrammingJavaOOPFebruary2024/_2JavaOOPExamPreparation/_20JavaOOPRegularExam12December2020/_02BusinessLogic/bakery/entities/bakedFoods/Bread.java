package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._02BusinessLogic.bakery.entities.bakedFoods;

public class Bread extends BaseFood {
    private static final double PORTION = 200;
    public Bread(String name, double price) {
        super(name, PORTION, price);
    }
}
