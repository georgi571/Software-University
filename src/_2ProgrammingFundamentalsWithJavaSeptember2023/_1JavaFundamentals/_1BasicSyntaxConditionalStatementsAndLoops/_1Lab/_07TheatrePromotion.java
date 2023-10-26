package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._1Lab;

import java.util.Scanner;

public class _07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        if (typeOfDay.equals("Weekday")) {
            if (age >= 0 && age <= 18) {
                System.out.println("12$");
            }else if (age >= 19 && age <= 64) {
                System.out.println("18$");
            }else if (age >= 65 && age <= 122) {
                System.out.println("12$");
            } else {
                System.out.println("Error!");
            }
        } else if (typeOfDay.equals("Weekend")) {
            if (age >= 0 && age <= 18) {
                System.out.println("15$");
            }else if (age >= 19 && age <= 64) {
                System.out.println("20$");
            }else if (age >= 65 && age <= 122) {
                System.out.println("15$");
            } else {
                System.out.println("Error!");
            }
        } else if (typeOfDay.equals("Holiday")) {
            if (age >= 0 && age <= 18) {
                System.out.println("5$");
            }else if (age >= 19 && age <= 64) {
                System.out.println("12$");
            }else if (age >= 65 && age <= 122) {
                System.out.println("10$");
            } else {
                System.out.println("Error!");
            }
        }
    }
}
