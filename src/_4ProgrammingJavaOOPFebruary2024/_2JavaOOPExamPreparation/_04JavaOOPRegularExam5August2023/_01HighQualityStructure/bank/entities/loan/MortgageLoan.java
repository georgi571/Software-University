package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._01HighQualityStructure.bank.entities.loan;

public class MortgageLoan extends BaseLoan {
    private static final int INTEREST_RATE = 3;
    private static final double AMOUNT = 50000;

    public MortgageLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
