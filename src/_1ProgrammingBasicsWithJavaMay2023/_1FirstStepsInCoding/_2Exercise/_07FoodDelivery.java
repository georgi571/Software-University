package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._2Exercise;

import java.util.Scanner;

public class _07FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chickenMenuCount = Integer.parseInt(scanner.nextLine());
        int fishMenuCount = Integer.parseInt(scanner.nextLine());
        int vegetarianMenuCount = Integer.parseInt(scanner.nextLine());
        double chickenSum = chickenMenuCount * 10.35;
        double fishSum = fishMenuCount * 12.40;
        double vegetarianSum = vegetarianMenuCount * 8.15;
        double totalSum = chickenSum + fishSum + vegetarianSum;
        double desertPrice = totalSum * 0.20;
        double finalPrice = totalSum + desertPrice + 2.50;
        System.out.println(finalPrice);
    }
}
