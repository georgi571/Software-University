package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            boolean isValidSumDigit = checkSumDigitDivisibleBy8(i);
            boolean isContainsOddDigit = checkDigitContainOdd(i);
            if (isValidSumDigit && isContainsOddDigit){
                System.out.println(i);
            }
        }
    }
    public static boolean checkSumDigitDivisibleBy8(int number){
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkDigitContainOdd(int number) {
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                return true;
            } else {
                number /= 10;
            }
        }
        return false;
    }
}
