package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._1Lab;

import java.util.Scanner;

public class _10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= 10 ; i++) {
            int sum = n * i;
            System.out.printf("%d X %d = %d%n",n, i, sum);
        }
    }
}
