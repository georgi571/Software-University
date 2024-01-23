package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._15JavaAdvancedRetakeExam18August2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> liquids = new ArrayDeque<>();
        List<Integer> allLiquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allLiquids.size(); i++) {
            liquids.offer(allLiquids.get(i));
        }
        Deque<Integer> ingredients = new ArrayDeque<>();
        List<Integer> allIngredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allIngredients.size(); i++) {
            ingredients.push(allIngredients.get(i));
        }
        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquids = liquids.poll();
            int currentIngredients = ingredients.pop();
            int sum = currentLiquids + currentIngredients;
            if (sum == 25) {
                biscuit++;
            } else if (sum == 50) {
                cake++;
            } else if (sum == 75) {
                pastry++;
            } else if (sum == 100) {
                pie++;
            } else {
                currentIngredients += 3;
                ingredients.push(currentIngredients);
            }
        }
        if (biscuit > 0 && cake > 0 && pastry > 0 && pie > 0) {
            System.out.printf("Great! You succeeded in cooking all the food!%n");
        } else {
            System.out.printf("What a pity! You didn't have enough materials to cook everything.%n");
        }
        System.out.printf("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.printf("none%n");
        } else {
            while (!liquids.isEmpty()) {
                System.out.printf("%d", liquids.poll());
                if (!liquids.isEmpty()) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
        System.out.printf("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.printf("none%n");
        } else {
            while (!ingredients.isEmpty()) {
                System.out.printf("%d", ingredients.pop());
                if (!ingredients.isEmpty()) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
        System.out.printf("Biscuit: %d%n", biscuit);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Pie: %d%n", pie);
        System.out.printf("Pastry: %d%n", pastry);
    }
}
