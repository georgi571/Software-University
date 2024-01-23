package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._08JavaAdvancedRegularExam22October2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> caffeinе = new ArrayDeque<>();
        List<Integer> allCaffeinе = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allCaffeinе.size(); i++) {
            caffeinе.push(allCaffeinе.get(i));
        }
        Deque<Integer> energyDrink = new ArrayDeque<>();
        List<Integer> allEnergyDrink = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allEnergyDrink.size(); i++) {
            energyDrink.offer(allEnergyDrink.get(i));
        }
        int maximumCaffeine = 0;
        while (!caffeinе.isEmpty() && !energyDrink.isEmpty()) {
            int currentCaffeine = caffeinе.pop();
            int currentEnergyDrink = energyDrink.poll();
            int result = currentEnergyDrink * currentCaffeine;
            if (result + maximumCaffeine <= 300) {
                maximumCaffeine += result;
            } else {
                energyDrink.offer(currentEnergyDrink);
                maximumCaffeine -= 30;
                if (maximumCaffeine < 0) {
                    maximumCaffeine = 0;
                }
            }
        }
        if (!energyDrink.isEmpty()) {
            System.out.printf("Drinks left: ");
            while (!energyDrink.isEmpty()) {
                System.out.printf("%d", energyDrink.poll());
                if (!energyDrink.isEmpty()) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        } else {
            System.out.printf("At least Stamat wasn't exceeding the maximum caffeine.%n");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", maximumCaffeine);
    }
}
