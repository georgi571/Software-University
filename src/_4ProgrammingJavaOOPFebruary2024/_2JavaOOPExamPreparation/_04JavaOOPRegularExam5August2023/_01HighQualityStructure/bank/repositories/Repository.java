package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._01HighQualityStructure.bank.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._01HighQualityStructure.bank.entities.loan.Loan;

public interface Repository {

    void addLoan(Loan loan);

    boolean removeLoan(Loan loan);

    Loan findFirst(String type);
}
