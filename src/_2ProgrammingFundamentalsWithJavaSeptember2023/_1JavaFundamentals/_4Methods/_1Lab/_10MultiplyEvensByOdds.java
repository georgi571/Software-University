package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._1Lab;

import java.util.Scanner;

public class _10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        getMultipleOfEvensAndOdds(number);
    }
    private static void getMultipleOfEvensAndOdds(int number) {
        int evenSum = getSumOfEvensDigit(number);
        int oddsSum = getSumOfOddsDigit(number);
        int sum = evenSum * oddsSum;
        System.out.printf("%d", sum);
    }
    private static int getSumOfEvensDigit(int number) {
        int evenSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            number /= 10;
        }
        return evenSum;
    }
    private static int getSumOfOddsDigit(int number) {
        int oddsSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 1) {
                oddsSum += digit;
            }
            number /= 10;
        }
        return oddsSum;
    }
}
