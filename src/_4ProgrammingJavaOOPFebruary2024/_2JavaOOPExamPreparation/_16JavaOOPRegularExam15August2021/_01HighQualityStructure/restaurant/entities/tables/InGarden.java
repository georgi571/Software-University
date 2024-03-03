package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021._01HighQualityStructure.restaurant.entities.tables;

public class InGarden extends BaseTable {
    private static final double PRICE_PER_PERSON = 4.50;
    public InGarden(int number, int size) {
        super(number, size, PRICE_PER_PERSON);
    }
}
