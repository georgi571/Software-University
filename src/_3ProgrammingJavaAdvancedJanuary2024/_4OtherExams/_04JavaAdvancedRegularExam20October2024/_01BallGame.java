package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._04JavaAdvancedRegularExam20October2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01BallGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> strength = new ArrayDeque<>();
        List<Integer> allStrength = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allStrength.size(); i++) {
            strength.push(allStrength.get(i));
        }
        Deque<Integer> accuracy = new ArrayDeque<>();
        List<Integer> allAccuracy = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allAccuracy.size(); i++) {
            accuracy.offer(allAccuracy.get(i));
        }

        int totalScoredGoals = 0;

        while (!strength.isEmpty() && !accuracy.isEmpty()) {
            int currentAccuracy = accuracy.peek();
            int currentStrength = strength.peek();

            if (currentAccuracy + currentStrength == 100) {
                totalScoredGoals++;
                accuracy.poll();
                strength.pop();
            } else if (currentAccuracy + currentStrength < 100) {
                if (currentStrength < currentAccuracy) {
                    strength.pop();
                } else if (currentStrength > currentAccuracy) {
                    accuracy.poll();
                } else {
                    currentStrength += currentAccuracy;
                    accuracy.poll();
                    strength.pop();
                    strength.push(currentStrength);
                }
            } else {
                accuracy.poll();
                strength.pop();
                currentStrength -= 10;
                if (currentStrength > 0) {
                    strength.push(currentStrength);
                }
                accuracy.offer(currentAccuracy);
            }
        }

        if (totalScoredGoals == 3) {
            System.out.printf("Paul scored a hat-trick!%n");
        } else if (totalScoredGoals == 0) {
            System.out.printf("Paul failed to score a single goal.%n");
        } else if (totalScoredGoals > 3) {
            System.out.printf("Paul performed remarkably well!%n");
        } else {
            System.out.printf("Paul failed to make a hat-trick.%n");
        }

        if (totalScoredGoals > 0) {
            System.out.printf("Goals scored: %d%n", totalScoredGoals);
        }

        if (!strength.isEmpty()) {
            System.out.printf("Strength values left: ");
            Deque<Integer> leftStrength = new ArrayDeque<>();
            while (!strength.isEmpty()){
                leftStrength.push(strength.pop());
            }
            while (!leftStrength.isEmpty()){
                if (leftStrength.size() > 1) {
                    System.out.printf("%d, ", leftStrength.pop());
                } else {
                    System.out.printf("%d", leftStrength.pop());
                }
            }
        }

        if (!accuracy.isEmpty()) {
            System.out.printf("Accuracy values left: ");
            while (!accuracy.isEmpty()){
                if (accuracy.size() > 1) {
                    System.out.printf("%d, ", accuracy.poll());
                } else {
                    System.out.printf("%d", accuracy.poll());
                }
            }
        }
    }
}
