package _1ProgrammingBasicsWithJavaMay2023._1Lab;

import java.util.Scanner;

public class _09YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double allArea = Double.parseDouble(scanner.nextLine());
        double totalSum = allArea * 7.61;
        double discount = totalSum * 0.18;
        double sumWithoutDiscount = totalSum - discount;
        System.out.printf("The final price is: %.2f lv.%n", sumWithoutDiscount);
        System.out.printf("The discount is: %.2f lv.%n", discount);
    }
}
