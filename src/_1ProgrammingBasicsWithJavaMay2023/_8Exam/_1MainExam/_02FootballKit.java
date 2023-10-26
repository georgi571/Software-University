package _1ProgrammingBasicsWithJavaMay2023._8Exam._1MainExam;

import java.util.Scanner;

public class _02FootballKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceOfTShirt = Double.parseDouble(scanner.nextLine());
        double sumNeededForBall = Double.parseDouble(scanner.nextLine());
        double priceOfShorts = priceOfTShirt * 0.75;
        double priceOfSocks = priceOfShorts * 0.20;
        double priceOfButtons = 2 * (priceOfTShirt + priceOfShorts);
        double totalSum = priceOfTShirt + priceOfShorts + priceOfSocks + priceOfButtons;
        double sumAfterDiscount = totalSum * 0.85;
        if (sumAfterDiscount >= sumNeededForBall) {
            System.out.printf("Yes, he will earn the world-cup replica ball!%n");
            System.out.printf("His sum is %.2f lv.", sumAfterDiscount);
        } else {
            double diff = sumNeededForBall - sumAfterDiscount;
            System.out.printf("No, he will not earn the world-cup replica ball.%n");
            System.out.printf("He needs %.2f lv. more.", diff);
        }
    }
}