package _1ProgrammingBasicsWithJavaMay2023._4ForLoop._2Exercise;

import java.util.Scanner;

public class _02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int currentSum = Integer.parseInt(scanner.nextLine());
            sum = sum + currentSum;
            if (currentSum > max) {
                max = currentSum;
            }
        }
        int sumWithoutMax = sum - max;
        if (max == sumWithoutMax) {
            System.out.printf("Yes%nSum = %d", max);
        } else {
            int diff = Math.abs(max-sumWithoutMax);
            System.out.printf("No%nDiff = %d", diff);
        }
    }
}
