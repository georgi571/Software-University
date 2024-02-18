package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._8ExceptionsAndErrorHandling._1Lab;

import java.io.IOException;
import java.util.Scanner;

public class _03EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int startRange = 1;
        int endRange = 100;
        int counter = 0;
        while (counter < 10) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number > startRange && number < endRange) {
                    numbers[counter] = number;
                    startRange = number;
                    counter++;
                } else {
                    throw new IOException(String.format("Your number is not in range %d - 100!", startRange));
                }
            }catch (IOException exception) {
                System.out.printf("%s%n", exception.getMessage());
            } catch (NumberFormatException exception) {
                System.out.printf("Invalid Number!%n");
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d", numbers[i]);
            if (i < numbers.length - 1) {
                System.out.printf(", ");
            }
        }
    }
}
