package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._3MoreExercise;

import java.util.Scanner;

public class _07HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double wall1 = x * x;
        double wall2 = (x * x) - (1.2 * 2);
        double wall3 = (x * y) - (1.5 * 1.5);
        double wall4 = (x * y) - (1.5 * 1.5);
        double roof1 = x * y;
        double roof2 = x * y;
        double roof3 = (x * h) / 2;
        double roof4 = (x * h) / 2;
        double walls = wall1 + wall2 + wall3 + wall4;
        double roofs = roof1 + roof2 + roof3 + roof4;
        double paintForWalls = walls / 3.4;
        double paintForRoofs = roofs / 4.3;
        System.out.printf("%.2f%n%.2f", paintForWalls, paintForRoofs);
    }
}
