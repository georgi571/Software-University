package _1ProgrammingBasicsWithJavaMay2023._6NestedLoops._2Exercise;

import java.util.Scanner;

public class _02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        for (int i = firstNum; i <= secondNum; i++) {
            int currentNum = i;
            int sumEven = 0;
            int sumOdd = 0;
            for (int j = 0; j < 6; j++) {
                int lastDigit = currentNum % 10;
                currentNum = currentNum / 10;
                if (j % 2 == 0) {
                    sumEven += lastDigit;
                } else {
                    sumOdd += lastDigit;
                }
            }
            if (sumEven == sumOdd) {
                System.out.print(i + " ");
            }
        }
    }
}
