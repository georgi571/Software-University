package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._3MoreExercise;

import java.util.Scanner;

public class _03Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xSMeters = Integer.parseInt(scanner.nextLine());
        double yGrapePer1sMeter = Double.parseDouble(scanner.nextLine());
        int zNeededLittersWine = Integer.parseInt(scanner.nextLine());
        int numberOfWorkers = Integer.parseInt(scanner.nextLine());
        double grape = xSMeters * yGrapePer1sMeter;
        double grapeForWine = grape * 0.40;
        double wine = grapeForWine / 2.5;
        double different = Math.abs(wine-zNeededLittersWine);
        double diff = Math.floor(wine);
        double different1 = Math.floor(different);
        double leftLitter = diff - zNeededLittersWine;
        double litterPerWorkers = leftLitter / numberOfWorkers;
        double litterPer1Worker = Math.ceil(litterPerWorkers);
        if (diff < zNeededLittersWine) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", different1);
        } else if (diff >= zNeededLittersWine) {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n%.0f liters left -> %.0f liters per person.", diff, leftLitter, litterPer1Worker);
        }
    }
}
