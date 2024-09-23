package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _06TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());
        double moneyPerMonth =  0.00;
        double moneyPerSeason = 0.00;
        if (season.equals("Spring") || season.equals("Autumn")) {
            if (kmPerMonth <= 5000) {
                moneyPerMonth = kmPerMonth * 0.75;
                moneyPerSeason = moneyPerMonth * 4;
            } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                moneyPerMonth = kmPerMonth * 0.95;
                moneyPerSeason = moneyPerMonth * 4;
            } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                moneyPerMonth = kmPerMonth * 1.45;
                moneyPerSeason = moneyPerMonth * 4;
            }
        } else if (season.equals("Summer")) {
            if (kmPerMonth <= 5000) {
                moneyPerMonth = kmPerMonth * 0.90;
                moneyPerSeason = moneyPerMonth * 4;
            } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                moneyPerMonth = kmPerMonth * 1.10;
                moneyPerSeason = moneyPerMonth * 4;
            } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                moneyPerMonth = kmPerMonth * 1.45;
                moneyPerSeason = moneyPerMonth * 4;
            }
        } else if (season.equals("Winter")) {
            if (kmPerMonth <= 5000) {
                moneyPerMonth = kmPerMonth * 1.05;
                moneyPerSeason = moneyPerMonth * 4;
            } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
                moneyPerMonth = kmPerMonth * 1.25;
                moneyPerSeason = moneyPerMonth * 4;
            } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                moneyPerMonth = kmPerMonth * 1.45;
                moneyPerSeason = moneyPerMonth * 4;
            }
        }
        double tax = moneyPerSeason * 0.10;
        double salaryAfterTax = moneyPerSeason - tax;
        System.out.printf("%.2f", salaryAfterTax);
    }
}
