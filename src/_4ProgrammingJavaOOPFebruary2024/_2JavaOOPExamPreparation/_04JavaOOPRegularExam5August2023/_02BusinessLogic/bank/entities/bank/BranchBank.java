package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.bank;

public class BranchBank extends BaseBank {
    private static final int CAPACITY = 25;
    public BranchBank(String name) {
        super(name, CAPACITY);
    }
}
