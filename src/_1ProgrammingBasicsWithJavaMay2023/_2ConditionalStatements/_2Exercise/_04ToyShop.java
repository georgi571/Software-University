package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._2Exercise;

import java.util.Scanner;

public class _04ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzleCount = Integer.parseInt(scanner.nextLine());
        int dollsCount = Integer.parseInt(scanner.nextLine());
        int teddiesCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int trucksCount = Integer.parseInt(scanner.nextLine());
        double puzzlePrice = 2.60;
        double dollsPrice = 3;
        double teddiesPrice = 4.10;
        double minionsPrice = 8.20;
        double truckPrice = 2;
        double totalSum = (puzzlePrice * puzzleCount) + (dollsPrice * dollsCount) + (teddiesPrice * teddiesCount) + (minionsPrice * minionsCount) + (truckPrice * trucksCount);
        int totalCountToys = puzzleCount + dollsCount + teddiesCount + minionsCount + trucksCount;
        if (totalCountToys >= 50){
            totalSum = totalSum * 0.75;
        }
        totalSum = totalSum * 0.90;
        double diff = Math.abs(totalSum - tripPrice);
        if (totalSum >= tripPrice){
            System.out.printf("Yes! %.2f lv left.", diff);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.",diff);
        }
    }
}
