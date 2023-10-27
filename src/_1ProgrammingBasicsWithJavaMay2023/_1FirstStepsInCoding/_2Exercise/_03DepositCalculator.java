package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._2Exercise;

import java.util.Scanner;

public class _03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double depositSum = Double.parseDouble(scanner.nextLine());
        int depositDue = Integer.parseInt(scanner.nextLine());
        double interestPercent = Double.parseDouble(scanner.nextLine());
        double annualInterest = depositSum * interestPercent/100;
        double monthlyInterest = annualInterest / 12;
        double totalSum = depositSum + depositDue * monthlyInterest;
        System.out.println(totalSum);
    }
}
