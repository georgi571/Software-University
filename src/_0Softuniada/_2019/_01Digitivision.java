package _0Softuniada._2019;

import java.util.Scanner;

public class _01Digitivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int sum = n1 + n2 + n3;
        int number1 = n1 * 100 + n2 * 10 + n3;
        int number2 = n1 * 100 + n3 * 10 + n2;
        int number3 = n2 * 100 + n1 * 10 + n3;
        int number4 = n2 * 100 + n3 * 10 + n1;
        int number5 = n3 * 100 + n1 * 10 + n2;
        int number6 = n3 * 100 + n2 * 10 + n1;
        double d1 = 1.0 * number1 / sum;
        double d2 = 1.0 * number2 / sum;
        double d3 = 1.0 * number3 / sum;
        double d4 = 1.0 * number4 / sum;
        double d5 = 1.0 * number5 / sum;
        double d6 = 1.0 * number6 / sum;
        int i1 = (int) d1;
        int i2 = (int) d2;
        int i3 = (int) d3;
        int i4 = (int) d4;
        int i5 = (int) d5;
        int i6 = (int) d6;
        boolean isFind = false;
        if (d1 - i1 == 0.00) {
            isFind = true;
        }
        if (d2 - i2 == 0.00) {
            isFind = true;
        }
        if (d3 - i3 == 0.00) {
            isFind = true;
        }
        if (d4 - i4 == 0.00) {
            isFind = true;
        }
        if (d5 - i5 == 0.00) {
            isFind = true;
        }
        if (d6 - i6 == 0.00) {
            isFind = true;
        }
        if (isFind) {
            System.out.printf("Digitivision successful!");
        } else {
            System.out.printf("No digitivision possible.");
        }
    }
}
