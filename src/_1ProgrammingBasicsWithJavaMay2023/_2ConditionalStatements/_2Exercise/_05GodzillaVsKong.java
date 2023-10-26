package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._2Exercise;

import java.util.Scanner;

public class _05GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int mutesCounts = Integer.parseInt(scanner.nextLine());
        double mutesClothingPrice = Double.parseDouble(scanner.nextLine());
        double decorPrice = budget * 0.10;
        double totalPriceMuteClothes = mutesCounts * mutesClothingPrice;
        if (mutesCounts > 150) {
            totalPriceMuteClothes = totalPriceMuteClothes * 0.90;
        }
        double finalPrice = decorPrice + totalPriceMuteClothes;
        double diff = Math.abs(finalPrice - budget);
        if (finalPrice <= budget){
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", diff);
        }
    }
}
