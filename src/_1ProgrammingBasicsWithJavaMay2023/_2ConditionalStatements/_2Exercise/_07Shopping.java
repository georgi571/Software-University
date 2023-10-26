package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._2Exercise;

import java.util.Scanner;

public class _07Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int videoCardCount = Integer.parseInt(scanner.nextLine());
        int processorCount = Integer.parseInt(scanner.nextLine());
        int ramCount = Integer.parseInt(scanner.nextLine());
        double videoCardPrice = videoCardCount * 250;
        double processorPrice = processorCount * (videoCardPrice * 0.35);
        double ramPrice = ramCount * (videoCardPrice * 0.10);
        double totalPrice = videoCardPrice + processorPrice + ramPrice;
        if (videoCardCount > processorCount) {
            totalPrice = totalPrice * 0.85;
        }
        double diff = Math.abs(totalPrice - budget);
        if (totalPrice <= budget) {
            System.out.printf("You have %.2f leva left!", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", diff);
        }
    }
}
