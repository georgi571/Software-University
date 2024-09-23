package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._3MoreExercise;

import java.util.Scanner;

public class _06Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double mackerelPricePerKilogram = Double.parseDouble(scanner.nextLine());
        double spratPricePerKilogram = Double.parseDouble(scanner.nextLine());
        double kilosOfBonito = Double.parseDouble(scanner.nextLine());
        double kilosOfSafrid = Double.parseDouble(scanner.nextLine());
        int kilosOfMussels = Integer.parseInt(scanner.nextLine());
        double bonitoPricePerKilogram = mackerelPricePerKilogram * 1.60;
        double safridPricePerKilogram = spratPricePerKilogram * 1.80;
        double musselsPricePerKilogram = 7.50;
        double sumForBonito = kilosOfBonito * bonitoPricePerKilogram;
        double sumForSafrid = kilosOfSafrid * safridPricePerKilogram;
        double sumForMussels = kilosOfMussels * musselsPricePerKilogram;
        double total = sumForMussels + sumForBonito + sumForSafrid;
        System.out.printf("%.2f", total);
    }
}
