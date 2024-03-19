package _0Softuniada._2020;

import java.util.Scanner;

public class _01DreamCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());
        double m = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double t = Double.parseDouble(scanner.nextLine());
        double savedMoney = 0;
        for (int i = 0; i < t; i++) {
            savedMoney += n - m;
            n += x;
            if (savedMoney >= y) {
                break;
            }
        }
        if (savedMoney >= y) {
            System.out.printf("Have a nice ride!");
        } else {
            System.out.printf("Work harder!");
        }
    }
}
