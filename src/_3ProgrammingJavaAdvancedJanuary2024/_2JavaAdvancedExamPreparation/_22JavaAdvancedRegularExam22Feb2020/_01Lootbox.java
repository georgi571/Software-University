package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._22JavaAdvancedRegularExam22Feb2020;

import java.util.*;
import java.util.stream.Collectors;

public class _01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> first = new ArrayDeque<>();
        List<Integer> allFirst = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allFirst.size(); i++) {
            first.offer(allFirst.get(i));
        }
        Deque<Integer> second = new ArrayDeque<>();
        List<Integer> allSecond = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allSecond.size(); i++) {
            second.push(allSecond.get(i));
        }
        int claimed = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            int currentFirst = first.peek();
            int currentSecond = second.pop();
            int sum = currentFirst + currentSecond;
            if (sum % 2 == 0) {
                claimed += sum;
                first.poll();
            } else {
                first.offer(currentSecond);
            }
        }
        if (first.isEmpty()) {
            System.out.printf("First lootbox is empty%n");
        }
        if (second.isEmpty()) {
            System.out.printf("Second lootbox is empty%n");
        }
        if (claimed >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", claimed);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", claimed);
        }
    }
}
