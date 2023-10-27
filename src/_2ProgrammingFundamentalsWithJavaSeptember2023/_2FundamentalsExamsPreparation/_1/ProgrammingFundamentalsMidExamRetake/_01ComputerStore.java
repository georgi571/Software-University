package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._1.ProgrammingFundamentalsMidExamRetake;

import java.util.Scanner;

public class _01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double priceWihtouTax = 0;
        while (!command.equals("special") && !command.equals("regular")) {
            double priceCurrentItem = Double.parseDouble(command);
            if (priceCurrentItem >= 0 ) {
                priceWihtouTax += priceCurrentItem;
            } else {
                System.out.println("Invalid price!");
            }
            command = scanner.nextLine();
        }
        if (priceWihtouTax > 0) {
            double taxes = priceWihtouTax * 0.20;
            double totalPrice = priceWihtouTax + taxes;
            if (command.equals("regular")) {
                System.out.printf("Congratulations you've just bought a new computer!%n");
                System.out.printf("Price without taxes: %.2f$%n", priceWihtouTax);
                System.out.printf("Taxes: %.2f$%n", taxes);
                System.out.printf("-----------%n");
                System.out.printf("Total price: %.2f$", totalPrice);
            } else if (command.equals("special")) {
                totalPrice = totalPrice * 0.90;
                System.out.printf("Congratulations you've just bought a new computer!%n");
                System.out.printf("Price without taxes: %.2f$%n", priceWihtouTax);
                System.out.printf("Taxes: %.2f$%n", taxes);
                System.out.printf("-----------%n");
                System.out.printf("Total price: %.2f$", totalPrice);
            }
        } else {
            System.out.printf("Invalid order!%n");
        }
    }
}
