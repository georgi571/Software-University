package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _05Series {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfSeries = Integer.parseInt(scanner.nextLine());
        double totalPriceForAllSeries = 0;
        for (int i = 0; i < numberOfSeries; i++) {
            String nameOfTheSeries = scanner.nextLine();
            double priceForSeries = Double.parseDouble(scanner.nextLine());
            if (nameOfTheSeries.equals("Thrones")) {
                priceForSeries *= 0.50;
            } else if (nameOfTheSeries.equals("Lucifer")) {
                priceForSeries *= 0.60;
            } else if (nameOfTheSeries.equals("Protector")) {
                priceForSeries *= 0.70;
            } else if (nameOfTheSeries.equals("TotalDrama")) {
                priceForSeries *= 0.80;
            } else if (nameOfTheSeries.equals("Area")) {
                priceForSeries *= 0.90;
            }
            totalPriceForAllSeries += priceForSeries;
        }
        double diff = Math.abs(budget - totalPriceForAllSeries);
        if (budget >= totalPriceForAllSeries) {
            System.out.printf("You bought all the series and left with %.2f lv.", diff);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!",diff);
        }
    }
}
