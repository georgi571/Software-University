package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._01HighQualityStructure.bank.entities.client;

public class Student extends BaseClient {
    private static final int INTEREST = 2;
    private static final int INCREASE_INTEREST = 1;
    public Student(String name, String ID, double income) {
        super(name, ID, INTEREST, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + INCREASE_INTEREST);
    }
}
