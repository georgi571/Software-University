package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._2Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int n = n1[0];
        int s = n1[1];
        int x = n1[2];
        int[] n2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numbers.push(n2[i]);
        }
        for (int i = 0; i < s; i++) {
            numbers.pop();
        }
        if (!numbers.isEmpty()) {
            if (numbers.contains(x)){
                System.out.printf("true%n");
            } else {
                System.out.printf("%d%n", Collections.min(numbers));
            }
        } else {
            System.out.printf("0%n");
        }
    }
}
