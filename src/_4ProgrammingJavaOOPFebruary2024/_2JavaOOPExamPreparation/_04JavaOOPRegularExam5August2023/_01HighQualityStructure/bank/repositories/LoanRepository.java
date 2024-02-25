package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._01HighQualityStructure.bank.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._01HighQualityStructure.bank.entities.loan.Loan;

import java.util.Collection;

public class LoanRepository implements Repository{
    private Collection<Loan> loans;

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public boolean removeLoan(Loan loan) {
        if (loans.contains(loan)) {
            loans.remove(loan);
            return true;
        }
        return false;
    }

    @Override
    public Loan findFirst(String type) {
        for (Loan loan : this.loans) {
            if (loan.getClass().getSimpleName().equals(type)) {
                return loan;
            }
        }
        return null;
    }
}
