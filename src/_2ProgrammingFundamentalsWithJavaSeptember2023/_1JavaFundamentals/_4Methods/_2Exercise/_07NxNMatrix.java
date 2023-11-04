package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printTable(n);
    }
    public static void printTable (int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
