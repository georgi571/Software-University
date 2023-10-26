package _1ProgrammingBasicsWithJavaMay2023._8Exam._1MainExam;

import java.util.Scanner;

public class _03ExcursionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        double pricePerPeople = 0.0;
        double totalPrice = 0.0;
        if (season.equals("spring")) {
            if (numberOfPeople <= 5) {
                pricePerPeople = 50.00;
                totalPrice = numberOfPeople * pricePerPeople;
            } else if (numberOfPeople > 5) {
                pricePerPeople = 48.00;
                totalPrice = numberOfPeople * pricePerPeople;
            }
        } else if (season.equals("summer")) {
            if (numberOfPeople <= 5) {
                pricePerPeople = 48.50;
                totalPrice = numberOfPeople * pricePerPeople;
                totalPrice = totalPrice * 0.85;
            } else if (numberOfPeople > 5) {
                pricePerPeople = 45.00;
                totalPrice = numberOfPeople * pricePerPeople;
                totalPrice = totalPrice * 0.85;
            }
        } else if (season.equals("autumn")) {
            if (numberOfPeople <= 5) {
                pricePerPeople = 60.00;
                totalPrice = numberOfPeople * pricePerPeople;
            } else if (numberOfPeople > 5) {
                pricePerPeople = 49.50;
                totalPrice = numberOfPeople * pricePerPeople;
            }
        }else if (season.equals("winter")) {
            if (numberOfPeople <= 5) {
                pricePerPeople = 86.00;
                totalPrice = numberOfPeople * pricePerPeople;
                totalPrice = totalPrice * 1.08;
            } else if (numberOfPeople > 5) {
                pricePerPeople = 85.00;
                totalPrice = numberOfPeople * pricePerPeople;
                totalPrice = totalPrice * 1.08;
            }
        }
        System.out.printf("%.2f leva.", totalPrice);
    }
}