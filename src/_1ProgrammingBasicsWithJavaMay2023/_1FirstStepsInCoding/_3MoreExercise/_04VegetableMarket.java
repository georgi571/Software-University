package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._3MoreExercise;

import java.util.Scanner;

public class _04VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceForVegetables = Double.parseDouble(scanner.nextLine());
        double priceForFruits = Double.parseDouble(scanner.nextLine());
        int kgForVegetables = Integer.parseInt(scanner.nextLine());
        int kgForFruits = Integer.parseInt(scanner.nextLine());
        double totalPriceForVegetables = priceForVegetables * kgForVegetables;
        double totalPriceForFruits = priceForFruits * kgForFruits;
        double totalPrice = totalPriceForFruits + totalPriceForVegetables;
        double priceInEuro = totalPrice / 1.94;
        System.out.printf("%.2f", priceInEuro);
    }
}
