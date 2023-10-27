package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._4ProgrammingFundamentalsMidExam;

import java.util.Scanner;

public class _01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double foodInKG = Double.parseDouble(scanner.nextLine());
        double hayInKG = Double.parseDouble(scanner.nextLine());
        double coverInKG = Double.parseDouble(scanner.nextLine());
        double weightInKG = Double.parseDouble(scanner.nextLine());
        double foodInGr = foodInKG * 1000;
        double hayInGr = hayInKG * 1000;
        double coverInGr = coverInKG * 1000;
        double weightInGr = weightInKG * 1000;
        for (int i = 1; i <= 30 ; i++) {
            foodInGr -= 300;
            if (i % 2 == 0) {
                hayInGr -= foodInGr * 0.05;
            }
            if (i % 3 == 0) {
                coverInGr -= weightInGr * 1 / 3;
            }
            if (foodInGr <= 0 || hayInGr <= 0 || coverInGr <= 0) {
                System.out.printf("Merry must go to the pet store!");
                break;
            }
        }
        foodInKG = foodInGr / 1000;
        hayInKG = hayInGr / 1000;
        coverInKG = coverInGr / 1000;
        if (foodInGr > 0 && hayInGr > 0 && coverInGr > 0) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n",foodInKG, hayInKG, coverInKG);
        }
    }
}
