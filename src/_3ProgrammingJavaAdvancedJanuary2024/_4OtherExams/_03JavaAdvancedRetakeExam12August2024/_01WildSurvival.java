package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._03JavaAdvancedRetakeExam12August2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01WildSurvival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> beeGroups = new ArrayDeque<>();
        List<Integer> allBeeGroups = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allBeeGroups.size(); i++) {
            beeGroups.offer(allBeeGroups.get(i));
        }
        Deque<Integer> beeEatersGroup = new ArrayDeque<>();
        List<Integer> allBeeEatersGroup = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allBeeEatersGroup.size(); i++) {
            beeEatersGroup.push(allBeeEatersGroup.get(i));
        }
        while (!beeGroups.isEmpty() && !beeEatersGroup.isEmpty()) {
            int currentBee = beeGroups.poll();
            int currentBeeEater = beeEatersGroup.pop();
            while (currentBee > 0 && currentBeeEater > 0) {
                if (currentBee >= 7) {
                    currentBee -= 7;
                    currentBeeEater--;
                } else {
                    currentBee = 0;
                }
            }
            if (currentBeeEater > 0) {
                beeEatersGroup.push(currentBeeEater);
            }
            if (currentBee > 0) {
                beeGroups.offer(currentBee);
            }
        }
        System.out.printf("The final battle is over!%n");
        if (beeGroups.isEmpty() && beeEatersGroup.isEmpty()) {
            System.out.printf("But no one made it out alive!%n");
        } else if (beeEatersGroup.isEmpty()) {
            System.out.printf("Bee groups left: ");
            while (!beeGroups.isEmpty()) {
                if (beeGroups.size() == 1) {
                    System.out.printf("%d%n", beeGroups.poll());
                } else {
                    System.out.printf("%d, ", beeGroups.poll());
                }
            }
        } else {
            System.out.printf("Bee-eater groups left: ");
            List<Integer> beeEatersLeft = new ArrayList<>();
            while (!beeEatersGroup.isEmpty()) {
                beeEatersLeft.add(beeEatersGroup.pop());
            }
            for (int i = beeEatersLeft.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.printf("%d%n", beeEatersLeft.get(i));
                } else {
                    System.out.printf("%d, ", beeEatersLeft.get(i));
                }
            }
        }
    }
}
