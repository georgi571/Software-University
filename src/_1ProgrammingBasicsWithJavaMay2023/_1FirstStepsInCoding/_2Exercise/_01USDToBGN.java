package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._2Exercise;

import java.util.Scanner;

public class _01USDToBGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double usd = Double.parseDouble(input);
        double bgn = usd * 1.79549;
        System.out.println(bgn);
    }
}
