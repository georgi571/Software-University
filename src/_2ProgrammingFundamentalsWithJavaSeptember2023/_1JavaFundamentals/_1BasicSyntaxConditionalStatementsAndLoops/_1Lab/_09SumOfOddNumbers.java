package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._1Lab;

import java.util.Scanner;

public class _09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currentNumber = 1;
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            System.out.printf("%d%n",currentNumber);
            sum += currentNumber;
            currentNumber += 2;
        }
        System.out.printf("Sum: %d%n",sum);
    }
}
