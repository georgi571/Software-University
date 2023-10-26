package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _01Moon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double averageSpeed = Double.parseDouble(scanner.nextLine());
        double litters = Double.parseDouble(scanner.nextLine());
        double totalDistance = 384400 * 2;
        double hours = Math.ceil(totalDistance / averageSpeed);
        double totalHours = hours + 3;
        double usedLitters = (litters * totalDistance) / 100;
        System.out.printf("%.0f%n", totalHours);
        System.out.printf("%.0f%n", usedLitters);
    }
}