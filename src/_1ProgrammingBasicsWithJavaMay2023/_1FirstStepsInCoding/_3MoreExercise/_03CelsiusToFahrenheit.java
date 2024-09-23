package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._3MoreExercise;

import java.util.Scanner;

public class _03CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tC = Double.parseDouble(scanner.nextLine());
        double tF = tC * 9/5 + 32;
        System.out.printf("%.2f", tF);
    }
}
