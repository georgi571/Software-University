package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._02BusinessLogic.restaurant.entities.tables;

public class Indoors extends BaseTable {
    private static final double PRICE_PER_PERSON = 3.50;
    public Indoors(int number, int size) {
        super(number, size, PRICE_PER_PERSON);
    }
}
