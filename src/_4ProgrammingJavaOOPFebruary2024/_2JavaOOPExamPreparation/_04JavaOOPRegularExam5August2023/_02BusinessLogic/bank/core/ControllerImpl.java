package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.bank.Bank;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.bank.BranchBank;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.bank.CentralBank;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.client.Adult;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.client.Client;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.client.Student;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.loan.Loan;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.loan.MortgageLoan;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.entities.loan.StudentLoan;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.repositories.LoanRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository loans;
    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;
        if (type.equals("CentralBank")) {
            bank = new CentralBank(name);
        } else if (type.equals("BranchBank")) {
            bank = new BranchBank(name);
        } else {
            throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }
        this.banks.add(bank);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        if (type.equals("StudentLoan")) {
            loan = new StudentLoan();
        } else if (type.equals("MortgageLoan")) {
            loan = new MortgageLoan();
        } else {
            throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }
        this.loans.addLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan = this.loans.findFirst(loanType);
        if (loan == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }
        for (Bank bank : this.banks) {
            if (bank.getName().equals(bankName)) {
                bank.addLoan(loan);
                this.loans.removeLoan(loan);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;
        if (clientType.equals("Student")) {
            client = new Student(clientName, clientID, income);
        } else if (clientType.equals("Adult")) {
            client = new Adult(clientName, clientID, income);
        } else {
            throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }
        if (clientType.equals("Student")) {
            for (Bank bank : this.banks) {
                if (bank.getClass().getSimpleName().equals("BranchBank")) {
                    if (bank.getName().equals(bankName)) {
                        bank.addClient(client);
                        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
                    }
                }
            }
        } else if (clientType.equals("Adult")) {
            for (Bank bank : this.banks) {
                if (bank.getClass().getSimpleName().equals("CentralBank")) {
                    if (bank.getName().equals(bankName)) {
                        bank.addClient(client);
                        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
                    }
                }
            }
        }
        return String.format(UNSUITABLE_BANK);
    }

    @Override
    public String finalCalculation(String bankName) {
        double sum = 0;
        for (Bank bank : this.banks) {
            if (bank.getName().equals(bankName)) {
                for (Client client : bank.getClients()) {
                    sum += client.getIncome();
                }
                for (Loan loan : bank.getLoans()) {
                    sum += loan.getAmount();
                }
            }
        }
        return String.format(FUNDS_BANK, bankName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (Bank bank : this.banks) {
            statistics.append(bank.getStatistics());
        }
        return statistics.toString().trim();
    }
}