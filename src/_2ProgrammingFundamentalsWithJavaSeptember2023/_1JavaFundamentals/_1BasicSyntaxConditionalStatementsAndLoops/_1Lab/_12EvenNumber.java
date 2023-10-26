package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._1Lab;

import java.util.Scanner;

public class _12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        boolean isEvenIsFound = false;
        while (!isEvenIsFound) {
            int number = Math.abs(Integer.parseInt(command));
            if (number % 2 == 0) {
                isEvenIsFound = true;
                System.out.printf("The number is: %d", number);
            } else {
                System.out.printf("Please write an even number.%n");
                command = scanner.nextLine();
            }
        }
    }
}
