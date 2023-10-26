package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._2Exercise;

import java.util.Scanner;

public class _06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int leftNumber = number;
        int counter = 0;
        while (leftNumber > 0) {
            int lastNumber = leftNumber % 10;
            int fact = 1;
            for (int i = 1; i <= lastNumber; i++) {
                fact = fact * i;
            }
            counter += fact;
            fact = 1;
            leftNumber = leftNumber / 10;
        }
        if (counter == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
