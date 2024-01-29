package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._1Lab;

import java.util.Scanner;

public class _01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printRhombus(n);
    }

    private static void printRhombus(int n) {
        printTopRows(n);
        printBottomRows(n);
    }

    private static void printBottomRows(int n) {
        for (int i = n - 1; i > 0; i--) {
            printRow(n, i);
        }
    }

    private static void printTopRows(int n) {
        for (int i = 1; i <= n; i++) {
            printRow(n, i);
        }
    }

    private static void printRow(int n, int i) {
        for (int j = n - i; j > 0; j--) {
            System.out.printf(" ");
        }
        for (int j = 0; j < i - 1; j++) {
            System.out.printf("* ");
        }
        System.out.printf("*%n");
    }
}
