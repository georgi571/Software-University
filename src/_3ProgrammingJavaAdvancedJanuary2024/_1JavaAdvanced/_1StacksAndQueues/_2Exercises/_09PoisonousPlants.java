package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._2Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> days = new ArrayDeque<>();
        ArrayDeque<Integer> leftPlants = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int getPlantsCountInBegin = plants.size();
            leftPlants.offer(plants.get(0));
            for (int j = 1; j < plants.size(); j++) {
                if (plants.get(j) <= plants.get(j - 1)) {
                    leftPlants.offer(plants.get(j));
                }
            }
            plants.clear();
            while (!leftPlants.isEmpty()) {
                plants.add(leftPlants.poll());
            }
            int getPlantsCountInEnd = plants.size();
            if (getPlantsCountInBegin != getPlantsCountInEnd) {
                days.push(i);
            } else {
                break;
            }
        }
        System.out.printf("%d%n", days.peek());
    }
}
