package _11ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._2Exercise;

import java.util.Scanner;

public class _02RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double radians = Double.parseDouble(input);
        double degrees = radians * 180 / Math.PI;
        System.out.println(degrees);
    }
}
