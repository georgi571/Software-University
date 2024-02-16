package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._10BasicAlgorithms._1Lab;

import java.util.Scanner;

public class _02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.printf("%d%n", calcFactorial(n));
    }
    public static int calcFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * calcFactorial(n - 1);
    }
}
