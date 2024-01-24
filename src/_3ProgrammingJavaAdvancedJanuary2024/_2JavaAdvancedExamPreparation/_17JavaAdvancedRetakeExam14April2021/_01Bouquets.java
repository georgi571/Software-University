package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._17JavaAdvancedRetakeExam14April2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> daffodils = new ArrayDeque<>();
        List<Integer> allDaffodils = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allDaffodils.size(); i++) {
            daffodils.offer(allDaffodils.get(i));
        }
        Deque<Integer> tulips = new ArrayDeque<>();
        List<Integer> allTulips = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allTulips.size(); i++) {
            tulips.push(allTulips.get(i));
        }
        int numberOfBouquets = 0;
        int numberOfFlowers = 0;
        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int currentDaffodils = daffodils.poll();
            int currentTulips = tulips.pop();
            int sum = currentTulips + currentDaffodils;
            while (sum > 15) {
                sum -= 2;
            }
            if (sum == 15) {
                numberOfBouquets++;
            } else if (sum < 15) {
                numberOfFlowers += sum;
            }
        }
        while (numberOfFlowers >= 15) {
            numberOfBouquets++;
            numberOfFlowers -= 15;
        }
        if (numberOfBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", numberOfBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", (5 - numberOfBouquets));
        }
    }
}
