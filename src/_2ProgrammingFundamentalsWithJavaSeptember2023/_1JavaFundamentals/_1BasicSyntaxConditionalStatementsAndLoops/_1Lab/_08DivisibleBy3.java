package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._1Lab;

import java.util.Scanner;

public class _08DivisibleBy3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.printf("%d%n", i);
            }
        }
    }
}
