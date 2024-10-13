package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._3MoreExercise;

import java.util.Scanner;

public class _05AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
        }
        double average = 1.0 * sum / n;
        System.out.printf("%.2f", average);
    }
}
