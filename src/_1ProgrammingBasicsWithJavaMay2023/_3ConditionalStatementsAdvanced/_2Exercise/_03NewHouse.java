package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._2Exercise;

import java.util.Scanner;

public class _03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flowers = scanner.nextLine();
        int numberOfFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double priceOfRoses = 5.00;
        double priceOfDahlias = 3.80;
        double priceOfTulips = 2.80;
        double priceOfNarcissus = 3.00;
        double priceOfGladiolus = 2.50;
        double finalPrice = 0;
        switch (flowers) {
            case "Roses":
                finalPrice = priceOfRoses * numberOfFlowers;
                if (numberOfFlowers > 80) {
                    finalPrice = finalPrice * 0.90;
                }
                break;
            case "Dahlias":
                finalPrice = priceOfDahlias * numberOfFlowers;
                if (numberOfFlowers > 90) {
                    finalPrice = finalPrice * 0.85;
                }
                break;
            case "Tulips":
                finalPrice = priceOfTulips * numberOfFlowers;
                if (numberOfFlowers > 80) {
                    finalPrice = finalPrice * 0.85;
                }
                break;
            case "Narcissus":
                finalPrice = priceOfNarcissus * numberOfFlowers;
                if (numberOfFlowers < 120) {
                    finalPrice = finalPrice * 1.15;
                }
                break;
            case "Gladiolus":
                finalPrice = priceOfGladiolus * numberOfFlowers;
                if (numberOfFlowers < 80) {
                    finalPrice = finalPrice * 1.20;
                }
                break;
        }
        double diff =Math.abs(budget - finalPrice);
        if (budget >= finalPrice) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, flowers, diff );
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", diff);
        }
    }
}
