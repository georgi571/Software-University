package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022._02BusinessLogic.christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy {
    private static final double PORTION = 250;

    public Stolen(String name, double price) {
        super(name, PORTION, price);
    }
}
