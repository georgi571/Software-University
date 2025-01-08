package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._05JavaAdvancedRetakeExam12December2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01ClickBait {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> suggested = new ArrayDeque<>();
        List<Integer> suggestedLinks = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();
        for (Integer integer : suggestedLinks) {
            suggested.offer(integer);
        }
        Deque<Integer> featured = new ArrayDeque<>();
        List<Integer> featuredArticles = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();
        for (Integer integer : featuredArticles) {
            featured.push(integer);
        }

        int goalValue = Integer.parseInt(scanner.nextLine());

        Deque<Integer> targetValues = new ArrayDeque<>();

        while (!suggested.isEmpty() && !featured.isEmpty()) {
            int suggestedValue = suggested.poll();
            int featuredValue = featured.pop();

            int reminder;

            if (suggestedValue > featuredValue) {
                reminder = suggestedValue % featuredValue;

                targetValues.offer(reminder * -1);

                if (reminder != 0) {
                    int doubleReminder = reminder * 2;
                    suggested.offer(doubleReminder);
                }
            } else if (featuredValue > suggestedValue) {
                reminder = featuredValue % suggestedValue;

                targetValues.offer(reminder);

                if (reminder != 0) {
                    int doubleReminder = reminder * 2;
                    featured.push(doubleReminder);
                }
            } else {
                targetValues.offer(0);
            }
        }

        int totalTargetValues = targetValues.stream().mapToInt(Integer::intValue).sum();

        String output = targetValues.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf("Final Feed: %s%n", output);

        if (totalTargetValues > goalValue) {
            System.out.printf("Goal achieved! Engagement Value: %d%n", totalTargetValues);
        } else {
            int shortBy;
            if (totalTargetValues > 0) {
                shortBy = goalValue - totalTargetValues;
            } else {
                shortBy = Math.abs(totalTargetValues - goalValue);
            }
            System.out.printf("Goal not achieved! Short by: %d%n", shortBy);
        }

    }
}
