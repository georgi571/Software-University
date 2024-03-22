package _0Softuniada._2022;

import java.util.Arrays;
import java.util.Scanner;

public class _03SortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sortedArray[i] = numbers[i];
            } else if (i % 2 == 1) {
                if (sortedArray[i - 1] >= numbers[i]) {
                    sortedArray[i] = numbers[i];
                } else {
                    sortedArray[i] = sortedArray[i - 1];
                    sortedArray[i - 1] = numbers[i];
                }
            } else {
                if (sortedArray[i - 1] <= numbers[i]) {
                    sortedArray[i] = numbers[i];
                } else {
                    sortedArray[i] = sortedArray[i - 1];
                    sortedArray[i - 1] = numbers[i];
                }
            }
        }
        for (int i : sortedArray) {
            System.out.printf("%d ", i);
        }
    }
}
