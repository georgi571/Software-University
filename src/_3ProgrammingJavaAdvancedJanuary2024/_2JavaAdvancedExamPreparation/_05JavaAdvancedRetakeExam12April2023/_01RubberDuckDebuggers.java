package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._05JavaAdvancedRetakeExam12April2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> time = new ArrayDeque<>();
        List<Integer> allTime = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allTime.size(); i++) {
            time.offer(allTime.get(i));
        }
        Deque<Integer> task = new ArrayDeque<>();
        List<Integer> allTask = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allTask.size(); i++) {
            task.push(allTask.get(i));
        }
        int darthVaderDuck = 0;
        int thorDucky = 0;
        int bigBlueRubberDucky = 0;
        int smallYellowRubberDucky = 0;
        while (!time.isEmpty() && !task.isEmpty()) {
            int currentTime = time.poll();
            int currentTask = task.pop();
            int result = currentTime * currentTask;
            if (result >= 0 && result <= 60) {
                darthVaderDuck++;
            } else if (result >= 61 && result <= 120) {
                thorDucky++;
            } else if (result >= 121 && result <= 180) {
                bigBlueRubberDucky++;
            } else if (result >= 181 && result <= 240) {
                smallYellowRubberDucky++;
            } else {
                currentTask -= 2;
                time.offer(currentTime);
                task.push(currentTask);
            }
        }
        System.out.printf("Congratulations, all tasks have been completed! Rubber ducks rewarded:%n");
        System.out.printf("Darth Vader Ducky: %d%n", darthVaderDuck);
        System.out.printf("Thor Ducky: %d%n", thorDucky);
        System.out.printf("Big Blue Rubber Ducky: %d%n", bigBlueRubberDucky);
        System.out.printf("Small Yellow Rubber Ducky: %d%n", smallYellowRubberDucky);
    }
}
