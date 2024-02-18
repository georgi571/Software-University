package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._8ExceptionsAndErrorHandling._1Lab;

import java.util.Scanner;

public class _02SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            if (number >= 0) {
                Double squareNumber = Math.sqrt(number);
                System.out.printf("%.2f%n", squareNumber);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException exception) {
            System.out.printf("Invalid%n");
        } finally {
            System.out.printf("Goodbye%n");
        }
    }
}
