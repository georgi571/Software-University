package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._1Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        mathPower(number, power);
    }
    private static void mathPower (double number, int power) {
        double result = 1;
        for (int i = 1; i <= power ; i++) {
            result *= number;
        }
        System.out.println(new DecimalFormat("0.####").format(result));
    }
}
