package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023._02BusinessLogic.bank.core;

public interface Controller {

    String addBank(String type, String name);
    String addLoan(String type);
    String returnedLoan(String bankName, String loanType);
    String addClient(String bankName, String clientType, String clientName, String clientID, double income);
    String finalCalculation(String bankName);
    String getStatistics();
}
