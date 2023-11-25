package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._2Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n.length; i++) {
            numbers.push(n[i]);
        }
        while (!numbers.isEmpty()){
            System.out.printf("%d ", numbers.pop());
        }
    }
}
