package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._3MoreExercise;

import java.util.Scanner;

public class _04RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= n; i++) {
            boolean isItPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isItPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isItPrime);
        }
    }
}
