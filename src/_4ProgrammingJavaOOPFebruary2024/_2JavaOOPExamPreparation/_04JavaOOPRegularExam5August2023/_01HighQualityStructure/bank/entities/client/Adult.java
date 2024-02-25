package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._01HighQualityStructure.bank.entities.client;

public class Adult extends BaseClient{
    private static final int INTEREST = 4;
    private static final int INCREASE_INTEREST = 2;
    public Adult(String name, String ID, double income) {
        super(name, ID, INTEREST, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + INCREASE_INTEREST);
    }
}
