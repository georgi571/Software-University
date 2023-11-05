package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._3MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().
                        trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] lis = new int[numbers.length];
        int[] prev = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            lis[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && lis[j] >= lis[i]) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int lastIndex = -1;
        int maxLen = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (maxLen < lis[i]) {
                maxLen = lis[i];
                lastIndex = i;
            }
        }
        int[] lisElements = new int[maxLen];
        while (lastIndex != -1) {
            lisElements[--maxLen] = numbers[lastIndex];
            lastIndex = prev[lastIndex];
        }
        System.out.println(Arrays.toString(lisElements).replaceAll("[,\\[\\]]", "").trim());
    }
}
