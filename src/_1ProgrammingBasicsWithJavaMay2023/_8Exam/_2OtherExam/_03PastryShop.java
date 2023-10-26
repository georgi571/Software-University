package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _03PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfTheCake = scanner.nextLine();
        int numberOfOrderedCakes = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        if (day <= 15) {
            if (nameOfTheCake.equals("Cake")) {
                price = numberOfOrderedCakes * 24.00;
            } else if (nameOfTheCake.equals("Souffle")) {
                price = numberOfOrderedCakes * 6.66;
            } else if (nameOfTheCake.equals("Baklava")) {
                price = numberOfOrderedCakes * 12.60;
            }
        } else if (day > 15) {
            if (nameOfTheCake.equals("Cake")) {
                price = numberOfOrderedCakes * 28.70;
            } else if (nameOfTheCake.equals("Souffle")) {
                price = numberOfOrderedCakes * 9.80;
            } else if (nameOfTheCake.equals("Baklava")) {
                price = numberOfOrderedCakes * 16.98;
            }
        }
        if (day < 23) {
            if (price >= 100 && price <= 200) {
                price = price * 0.85;
            } else if (price > 200) {
                price = price * 0.75;
            }
            if (day <= 15) {
                price = price * 0.90;
            }
        }
        System.out.printf("%.2f", price);
    }
}