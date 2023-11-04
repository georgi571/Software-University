package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._1Lab;

import java.util.Scanner;

public class _04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        if (command.equals("add")) {
            add(n1, n2);
        } else if (command.equals("multiply")) {
            multiply(n1, n2);
        } else if (command.equals("subtract")) {
            subtract(n1, n2);
        } else if (command.equals("divide")) {
            divide(n1, n2);
        }
    }
    public static void add (int n1, int n2) {
        int sum = n1 + n2;
        System.out.printf("%d", sum);
    }
    public static void multiply (int n1, int n2) {
        int sum = n1 * n2;
        System.out.printf("%d", sum);
    }
    public static void subtract (int n1, int n2) {
        int sum = n1 - n2;
        System.out.printf("%d", sum);
    }
    public static void divide (int n1, int n2) {
        int sum = n1 / n2;
        System.out.printf("%d", sum);
    }
}
