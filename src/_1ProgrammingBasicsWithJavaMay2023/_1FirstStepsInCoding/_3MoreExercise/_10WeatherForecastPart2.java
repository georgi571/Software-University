package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._3MoreExercise;

import java.util.Scanner;

public class _10WeatherForecastPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperature = Double.parseDouble(scanner.nextLine());
        if (temperature >= 26 && temperature <= 35) {
            System.out.println("Hot");
        } else if (temperature > 20 && temperature < 26) {
            System.out.println("Warm");
        } else if (temperature >= 15 && temperature <= 20) {
            System.out.println("Mild");
        } else if (temperature >= 12 && temperature < 15) {
            System.out.println("Cool");
        } else if (temperature >= 5 && temperature < 12) {
            System.out.println("Cold");
        } else {
            System.out.println("unknown");
        }
    }
}
