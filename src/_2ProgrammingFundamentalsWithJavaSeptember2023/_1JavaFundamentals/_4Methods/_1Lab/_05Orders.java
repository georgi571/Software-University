package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._1Lab;

import java.util.Scanner;

public class _05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        price(product, quantity);
    }
    public static void price (String product, int quantity) {
        double totalPrice = 0.0;
        if (product.equals("coffee")) {
            totalPrice = quantity * 1.50;
        } else if (product.equals("water")) {
            totalPrice = quantity * 1.00;
        } else if (product.equals("coke")) {
            totalPrice = quantity * 1.40;
        } else if (product.equals("snacks")) {
            totalPrice = quantity * 2.00;
        }
        System.out.printf("%.2f", totalPrice);
    }
}
