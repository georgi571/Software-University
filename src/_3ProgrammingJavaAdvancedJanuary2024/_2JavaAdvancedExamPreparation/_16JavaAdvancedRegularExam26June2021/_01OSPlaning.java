package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._16JavaAdvancedRegularExam26June2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> tasks = new ArrayDeque<>();
        List<Integer> allTasks = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allTasks.size(); i++) {
            tasks.push(allTasks.get(i));
        }
        Deque<Integer> threads = new ArrayDeque<>();
        List<Integer> allThreads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allThreads.size(); i++) {
            threads.offer(allThreads.get(i));
        }
        int taskToKill = Integer.parseInt(scanner.nextLine());
        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int currentTask = tasks.pop();
            if (currentTask == taskToKill) {
                break;
            }
            int currentThreads = threads.poll();
            if (currentThreads < currentTask) {
                tasks.push(currentTask);
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threads.peek(), taskToKill);
        while (!threads.isEmpty()) {
            System.out.printf("%d ", threads.poll());
        }
    }
}
