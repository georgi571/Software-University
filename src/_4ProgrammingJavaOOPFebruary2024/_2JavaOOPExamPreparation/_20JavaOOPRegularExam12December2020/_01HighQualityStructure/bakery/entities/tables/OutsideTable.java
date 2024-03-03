package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.entities.tables;

public class OutsideTable extends BaseTable {
    private static final double PRICE_PER_PERSON = 3.50;
    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
