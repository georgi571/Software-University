package _0Softuniada._2023;

import java.util.Arrays;
import java.util.Scanner;

public class _06Pancakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pancakes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < pancakes.length; i++) {
            if (sum < 0) {
                startIndex = i;
                endIndex = i;
                sum = 0;
            }

            sum += pancakes[i];
            endIndex = i;

            if (sum > maxSum) {
                maxStart = startIndex;
                maxEnd = endIndex;
                maxSum = sum;
            } else if (sum == maxSum && ((endIndex - startIndex) > (maxEnd - maxStart))) {
                maxStart = startIndex;
                maxEnd = endIndex;
            }
        }
        System.out.printf("%d %d %d", maxSum, maxStart, maxEnd);
    }
}

