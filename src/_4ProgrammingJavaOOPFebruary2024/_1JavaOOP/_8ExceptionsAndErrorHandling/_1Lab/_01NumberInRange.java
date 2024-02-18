package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._8ExceptionsAndErrorHandling._1Lab;

import java.util.Scanner;

public class _01NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] range = scanner.nextLine().split("\\s+");
        int startRange = Integer.parseInt(range[0]);
        int endRange = Integer.parseInt(range[1]);
        System.out.printf("Range: [%d...%d]%n", startRange, endRange);
        int validNumber = readValidNumber(scanner, startRange, endRange);
        System.out.printf("Valid number: %d%n", validNumber);
    }

    private static int readValidNumber(Scanner scanner, int startRange, int endRange) {
        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= startRange && number <= endRange) {
                    return number;
                }
            } catch (NumberFormatException exception) {
            }

            System.out.printf("Invalid number: %s%n", input);
        }
    }
}
