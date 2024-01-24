package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._20JavaAdvancedRetakeExam19August2020;

import java.util.*;
import java.util.stream.Collectors;

public class _01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> roses = new ArrayDeque<>();
        List<Integer> allRoses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allRoses.size(); i++) {
            roses.offer(allRoses.get(i));
        }
        Deque<Integer> lilies = new ArrayDeque<>();
        List<Integer> allLilies = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allLilies.size(); i++) {
            lilies.push(allLilies.get(i));
        }
        int numberOfWreaths = 0;
        int numberOfFlowers = 0;
        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int currentRoses = roses.poll();
            int currentLilies = lilies.pop();
            int sum = currentRoses + currentLilies;
            while (sum > 15) {
                sum -= 2;
            }
            if (sum == 15) {
                numberOfWreaths++;
            } else if (sum < 15) {
                numberOfFlowers += sum;
            }
        }
        while (numberOfFlowers >= 15) {
            numberOfWreaths++;
            numberOfFlowers -= 15;
        }
        if (numberOfWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", numberOfWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", (5 - numberOfWreaths));
        }
    }
}
