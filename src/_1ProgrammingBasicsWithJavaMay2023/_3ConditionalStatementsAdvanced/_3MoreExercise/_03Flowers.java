package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _03Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfChrysanthemums  = Integer.parseInt(scanner.nextLine());
        int numberOfRoses  = Integer.parseInt(scanner.nextLine());
        int numberOfTulips  = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        char dayIsHoliday = scanner.nextLine().charAt(0);
        double priceOfChrysanthemums = 0.00;
        double priceOfRoses = 0.00;
        double priceOfTulips = 0.00;
        double totalPrice = 0.00;
        int totalFlower = numberOfChrysanthemums + numberOfRoses + numberOfTulips;
        int priceOfArrange = 2;
        if (season.equals("Spring") || season.equals("Summer")) {
            priceOfChrysanthemums = numberOfChrysanthemums * 2.00;
            priceOfRoses = numberOfRoses * 4.10;
            priceOfTulips = numberOfTulips * 2.50;
            totalPrice = priceOfChrysanthemums + priceOfRoses + priceOfTulips;
            if (dayIsHoliday == 'Y') {
                totalPrice = totalPrice * 1.15;
            } if (season.equals("Spring")) {
                if (numberOfTulips > 7) {
                    totalPrice = totalPrice * 0.95;
                }
            }
        } else if (season.equals("Autumn") || season.equals("Winter")) {
            priceOfChrysanthemums = numberOfChrysanthemums * 3.75;
            priceOfRoses = numberOfRoses * 4.50;
            priceOfTulips = numberOfTulips * 4.15;
            totalPrice = priceOfChrysanthemums + priceOfRoses + priceOfTulips;
            if (dayIsHoliday == 'Y') {
                totalPrice = totalPrice * 1.15;
            } if (season.equals("Winter")) {
                if (numberOfRoses >= 10) {
                    totalPrice = totalPrice * 0.90;
                }
            }
        }
        if (totalFlower > 20) {
            totalPrice = totalPrice * 0.80;
        }
        totalPrice = totalPrice + priceOfArrange;
        System.out.printf("%.2f",totalPrice);
    }
}
