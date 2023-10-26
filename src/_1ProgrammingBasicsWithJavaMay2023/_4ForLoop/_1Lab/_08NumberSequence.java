package _1ProgrammingBasicsWithJavaMay2023._4ForLoop._1Lab;

import java.util.Scanner;

public class _08NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber > maxNum) {
                maxNum = currentNumber;
            }
            if (currentNumber < minNum) {
                minNum = currentNumber;
            }
        }
        System.out.printf("Max number: %d%nMin number: %d", maxNum, minNum);
    }
}