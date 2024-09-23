package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._3MoreExercise;

import java.util.Scanner;

public class _08CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double area = Math.PI * r * r;
        double perimeter = Math.PI * 2 * r;
        System.out.printf("%.2f%n%.2f",area, perimeter);
    }
}
