package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._21JavaAdvancedRegularExam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class _01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> effects = new ArrayDeque<>();
        List<Integer> allEffects = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allEffects.size(); i++) {
            effects.offer(allEffects.get(i));
        }
        Deque<Integer> casings = new ArrayDeque<>();
        List<Integer> allCasings = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allCasings.size(); i++) {
            casings.push(allCasings.get(i));
        }
        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;
        while (!effects.isEmpty() && !casings.isEmpty()) {
            int currentEffects = effects.peek();
            int currentCasings = casings.pop();
            int sum = currentEffects + currentCasings;
            if (sum == 40) {
                daturaBombs++;
                effects.poll();
            } else if (sum == 60) {
                cherryBombs++;
                effects.poll();
            } else if (sum == 120) {
                smokeDecoyBombs++;
                effects.poll();
            } else {
                currentCasings -= 5;
                casings.push(currentCasings);
            }
            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                break;
            }
        }
        if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
            System.out.printf("Bene! You have successfully filled the bomb pouch!%n");
        } else {
            System.out.printf("You don't have enough materials to fill the bomb pouch.%n");
        }
        System.out.printf("Bomb Effects: ");
        if (effects.isEmpty()) {
            System.out.printf("empty");
        } else {
            while (!effects.isEmpty()) {
                System.out.printf("%d", effects.poll());
                if (!effects.isEmpty()) {
                    System.out.printf(", ");
                }
            }
        }
        System.out.printf("%n");
        System.out.printf("Bomb Casings: ");
        if (casings.isEmpty()) {
            System.out.printf("empty");
        } else {
            while (!casings.isEmpty()) {
                System.out.printf("%d", casings.pop());
                if (!casings.isEmpty()) {
                    System.out.printf(", ");
                }
            }
        }
        System.out.printf("%n");
        System.out.printf("Cherry Bombs: %d%n", cherryBombs);
        System.out.printf("Datura Bombs: %d%n", daturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeDecoyBombs);
    }
}
