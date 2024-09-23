package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._3MoreExercise;

import java.util.Scanner;

public class _05TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double w = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double wInCm = w * 100;
        double hInCm = h * 100;
        double hMinusCorridor = hInCm - 100.00;
        double deskInRow = Math.floor(hMinusCorridor / 70);
        double rows = Math.floor(wInCm / 120);
        double numbersOfChairs = (deskInRow * rows) - 3;
        System.out.printf("%.0f", numbersOfChairs);
    }
}
