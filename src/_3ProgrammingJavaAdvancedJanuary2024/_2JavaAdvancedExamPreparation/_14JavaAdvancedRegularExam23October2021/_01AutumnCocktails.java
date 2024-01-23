package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._14JavaAdvancedRegularExam23October2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> bucket = new ArrayDeque<>();
        List<Integer> allBucket = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allBucket.size(); i++) {
            bucket.offer(allBucket.get(i));
        }
        Deque<Integer> freshness = new ArrayDeque<>();
        List<Integer> allFreshness = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allFreshness.size(); i++) {
            freshness.push(allFreshness.get(i));
        }
        int pearSour = 0;
        int theHarvest = 0;
        int apleHinny = 0;
        int highFashion = 0;
        while (!bucket.isEmpty() && !freshness.isEmpty()) {
            if (bucket.peek() == 0) {
                bucket.poll();
            } else {
                int currentBucket = bucket.poll();
                int currentFreshness = freshness.pop();
                int result = currentFreshness * currentBucket;
                if (result == 150) {
                    pearSour++;
                } else if (result == 250) {
                    theHarvest++;
                } else if (result == 300) {
                    apleHinny++;
                } else if (result == 400) {
                    highFashion++;
                } else {
                    currentBucket += 5;
                    bucket.offer(currentBucket);
                }
            }
        }
        if (pearSour > 0 && theHarvest > 0 && apleHinny > 0 && highFashion > 0) {
            System.out.printf("It's party time! The cocktails are ready!%n");
        } else {
            System.out.printf("What a pity! You didn't manage to prepare all cocktails.%n");
        }
        int sum = 0;
        while (!bucket.isEmpty()) {
            sum += bucket.poll();
        }
        while (!freshness.isEmpty()) {
            sum += freshness.pop();
        }
        if (sum > 0) {
            System.out.printf("Ingredients left: %d%n",sum);
        }
        if (apleHinny > 0) {
            System.out.printf(" # Apple Hinny --> %d%n", apleHinny);
        }
        if (highFashion > 0) {
            System.out.printf(" # High Fashion --> %d%n", highFashion);
        }
        if (pearSour > 0) {
            System.out.printf(" # Pear Sour --> %d%n", pearSour);
        }
        if (theHarvest > 0) {
            System.out.printf(" # The Harvest --> %d%n", theHarvest);
        }
    }
}
