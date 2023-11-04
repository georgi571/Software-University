package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
       while (!command.equals("END")) {
           System.out.printf("%b%n", isPalindromeNumber(command));
           command = scanner.nextLine();
       }
    }
    public static boolean isPalindromeNumber (String command) {
        String palindorome = "";
        for (int i = command.length() - 1; i >= 0; i--) {
            char singleDigit = command.charAt(i);
            palindorome = palindorome + singleDigit;
        }
        return palindorome.equals(command);
    }
}
