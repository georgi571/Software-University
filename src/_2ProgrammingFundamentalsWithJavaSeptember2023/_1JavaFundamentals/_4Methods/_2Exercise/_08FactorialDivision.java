package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        long factorialFirstNumber = calculateFactorial(firstNumber);
        long factorialSecondNumber = calculateFactorial(secondNumber);
        double result = factorialFirstNumber * 1.0 / factorialSecondNumber;
        System.out.printf("%.2f",result);
    }
    public static long calculateFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number ; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
