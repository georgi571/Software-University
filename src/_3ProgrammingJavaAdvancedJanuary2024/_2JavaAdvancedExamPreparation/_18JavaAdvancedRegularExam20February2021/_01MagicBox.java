package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._18JavaAdvancedRegularExam20February2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> firstBox = new ArrayDeque<>();
        List<Integer> allFirstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allFirstBox.size(); i++) {
            firstBox.offer(allFirstBox.get(i));
        }
        Deque<Integer> secondBox = new ArrayDeque<>();
        List<Integer> allSecondBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allSecondBox.size(); i++) {
            secondBox.push(allSecondBox.get(i));
        }
        int claimedItems = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.peek();
            int second = secondBox.pop();
            int sum = first + second;
            if (sum % 2 == 0) {
                claimedItems += sum;
                firstBox.poll();
            } else {
                firstBox.offer(second);
            }
        }
        if (firstBox.isEmpty()) {
            System.out.printf("First magic box is empty.%n");
        }
        if (secondBox.isEmpty()) {
            System.out.printf("Second magic box is empty.%n");
        }
        if (claimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", claimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d%n", claimedItems);
        }
    }
}
