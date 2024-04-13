package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _03MovieDestination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budgetForMovie = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int numberOfDays = Integer.parseInt(scanner.nextLine());
        double totalMoneyNeededForMovie = 0;
        if (destination.equals("Dubai")) {
            if (season.equals("Winter")) {
                totalMoneyNeededForMovie = numberOfDays * 45000;
            } else if (season.equals("Summer")) {
                totalMoneyNeededForMovie = numberOfDays * 40000;
            }
            totalMoneyNeededForMovie = totalMoneyNeededForMovie * 0.70;
        } else if (destination.equals("Sofia")) {
            if (season.equals("Winter")) {
                totalMoneyNeededForMovie = numberOfDays * 17000;
            } else if (season.equals("Summer")) {
                totalMoneyNeededForMovie = numberOfDays * 12500;
            }
            totalMoneyNeededForMovie = totalMoneyNeededForMovie * 1.25;
        } else if (destination.equals("London")) {
            if (season.equals("Winter")) {
                totalMoneyNeededForMovie = numberOfDays * 24000;
            } else if (season.equals("Summer")) {
                totalMoneyNeededForMovie = numberOfDays * 20250;
            }
        }
        double diff = Math.abs(budgetForMovie - totalMoneyNeededForMovie);
        if (totalMoneyNeededForMovie <= budgetForMovie) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", diff);
        } else {
            System.out.printf("The director needs %.2f leva more!", diff);
        }
    }
}
