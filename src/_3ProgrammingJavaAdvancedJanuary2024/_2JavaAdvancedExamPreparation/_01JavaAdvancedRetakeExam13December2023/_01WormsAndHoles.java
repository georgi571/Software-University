package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._01JavaAdvancedRetakeExam13December2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> worms = new ArrayDeque<>();
        Deque<Integer> holes = new ArrayDeque<>();
        int matches = 0;
        List<Integer> allWorms = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allWorms.size(); i++) {
            worms.push(allWorms.get(i));
        }
        List<Integer> allHoles = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allHoles.size(); i++) {
            holes.offer(allHoles.get(i));
        }
        while (!worms.isEmpty() && !holes.isEmpty()) {
            if (worms.peek() == holes.peek()) {
                worms.pop();
                holes.poll();
                matches++;
            } else {
                int newValueOfWorm = worms.pop() - 3;
                if (newValueOfWorm > 0) {
                    worms.push(newValueOfWorm);
                }
                holes.poll();
            }
        }
        if (matches == 0) {
            System.out.printf("There are no matches.%n");
        } else {
            System.out.printf("Matches: %d%n", matches);
        }
        if (worms.isEmpty()) {
            if (matches == allWorms.size()) {
                System.out.printf("Every worm found a suitable hole!%n");
            } else {
                System.out.printf("Worms left: none%n");
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> leftWorms = new ArrayList<>();
            while (!worms.isEmpty()) {
                leftWorms.add(0, worms.pop());
            }
            for (int i = 0; i < leftWorms.size() - 1; i++) {
                stringBuilder.append(leftWorms.get(i));
                stringBuilder.append(", ");
            }
            stringBuilder.append(leftWorms.get(leftWorms.size() - 1));
            System.out.printf("Worms left: %s%n", stringBuilder);
        }
        if (holes.isEmpty()) {
            System.out.printf("Holes left: none%n");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (!holes.isEmpty()) {
                stringBuilder.append(holes.poll());
                if (!holes.isEmpty()) {
                    stringBuilder.append(", ");
                }
            }
            System.out.printf("Holes left: %s%n", stringBuilder);
        }
    }
}
