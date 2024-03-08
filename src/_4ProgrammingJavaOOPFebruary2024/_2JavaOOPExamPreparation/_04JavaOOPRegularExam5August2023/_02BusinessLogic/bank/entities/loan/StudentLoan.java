package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.loan;

public class StudentLoan extends BaseLoan {
    private static final int INTEREST_RATE = 1;
    private static final double AMOUNT = 10000;

    public StudentLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
