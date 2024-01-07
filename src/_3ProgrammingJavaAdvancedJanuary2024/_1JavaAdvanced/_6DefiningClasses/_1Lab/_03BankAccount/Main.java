package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._1Lab._03BankAccount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> bank = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("\\s+");
            if (commandParts[0].equals("Create")) {
                create(bank);
            } else if (commandParts[0].equals("Deposit")) {
                deposit(commandParts, bank);
            } else if (commandParts[0].equals("SetInterest")) {
                setInterest(Double.parseDouble(commandParts[1]));
            } else if (commandParts[0].equals("GetInterest")) {
                printInterest(bank, Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]));
            }
            command = scanner.nextLine();
        }
    }
    private static void deposit(String[] commandParts, Map<Integer, BankAccount> bank) {
        int id = Integer.parseInt(commandParts[1]);
        int amount = Integer.parseInt(commandParts[2]);
        BankAccount bankAccount = bank.get(id);
        if (bankAccount != null) {
            bankAccount.deposit(amount);
            System.out.printf("Deposited %d to ID%d%n", amount, id);
        } else {
            System.out.printf("Account does not exist%n");
        }
    }
    private static void create(Map<Integer, BankAccount> bank) {
        BankAccount bankAccount = new BankAccount();
        bank.put(bankAccount.getId(), bankAccount);
        bankAccount.print();
    }
    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }
    private static void printInterest(Map<Integer, BankAccount> bank, int id, int years) {
        BankAccount bankAccount = bank.get(id);
        if (bankAccount != null) {
            System.out.printf("%.2f%n", bankAccount.getInterest(years));
        } else {
            System.out.printf("Account does not exist%n");
        }
    }
}
