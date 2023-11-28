package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._3MoreExercise;

import java.util.Scanner;

public class _04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printTribunacci(n);
    }
    private static void printTribunacci(int n) {
        int number1 = 1;
        int number2 = 1;
        int number3 = 2;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.printf("%d", number1);
            } else if (i == 2) {
                System.out.printf(" %d", number2);
            } else if (i == 3) {
                System.out.printf(" %d", number3);
            } else {
            int newNumber3 = number1 + number2 + number3;
            number1 = number2;
            number2 = number3;
            number3 = newNumber3;
            System.out.printf(" %d", newNumber3);
            }
        }
    }
}
