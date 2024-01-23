package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._11JavaAdvancedRetakeExam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> steel = new ArrayDeque<>();
        List<Integer> allSteel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allSteel.size(); i++) {
            steel.offer(allSteel.get(i));
        }
        Deque<Integer> carbon = new ArrayDeque<>();
        List<Integer> allCarbon = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allCarbon.size(); i++) {
            carbon.push(allCarbon.get(i));
        }
        int gladiusCount = 0;
        int shamshirCount = 0;
        int katanaCount = 0;
        int sabreCount = 0;
        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int currentSteel = steel.poll();
            int currentCarbon = carbon.pop();
            int sum = currentSteel + currentCarbon;
            if (sum == 70) {
                gladiusCount++;
            } else if (sum == 80) {
                shamshirCount++;
            } else if (sum == 90) {
                katanaCount++;
            } else if (sum == 110) {
                sabreCount++;
            } else {
                currentCarbon += 5;
                carbon.push(currentCarbon);
            }
        }
        int totalSwords = gladiusCount + shamshirCount + katanaCount + sabreCount;
        if (totalSwords > 0) {
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.printf("You did not have enough resources to forge a sword.%n");
        }
        System.out.printf("Steel left: ");
        if (steel.isEmpty()) {
            System.out.printf("none%n");
        } else {
            while (!steel.isEmpty()) {
                System.out.printf("%d", steel.poll());
                if (!steel.isEmpty()) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
        System.out.printf("Carbon left: ");
        if (carbon.isEmpty()) {
            System.out.printf("none%n");
        } else {
            while (!carbon.isEmpty()) {
                System.out.printf("%d", carbon.pop());
                if (!carbon.isEmpty()) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
        if (gladiusCount > 0) {
            System.out.printf("Gladius: %d%n", gladiusCount);
        }
        if (katanaCount > 0) {
            System.out.printf("Katana: %d%n", katanaCount);
        }
        if (sabreCount > 0) {
            System.out.printf("Sabre: %d%n", sabreCount);
        }
        if (shamshirCount > 0) {
            System.out.printf("Shamshir: %d%n", shamshirCount);
        }
    }
}
