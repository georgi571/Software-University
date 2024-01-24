package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._19JavaAdvancedRetakeExam16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class _01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> liquid = new ArrayDeque<>();
        List<Integer> allLiquid = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allLiquid.size(); i++) {
            liquid.offer(allLiquid.get(i));
        }
        Deque<Integer> ingredient = new ArrayDeque<>();
        List<Integer> allIngredient = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allIngredient.size(); i++) {
            ingredient.push(allIngredient.get(i));
        }
        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;
        while (!liquid.isEmpty() && !ingredient.isEmpty()) {
            int currentLiquid = liquid.poll();
            int currentIngredient = ingredient.pop();
            int sum = currentIngredient + currentLiquid;
            if (sum == 25) {
                bread++;
            } else if (sum == 50) {
                cake++;
            } else if (sum == 75) {
                pastry++;
            } else if (sum == 100) {
                fruitPie++;
            } else {
                currentIngredient += 3;
                ingredient.push(currentIngredient);
            }
        }
        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0) {
            System.out.printf("Wohoo! You succeeded in cooking all the food!%n");
        } else {
            System.out.printf("Ugh, what a pity! You didn't have enough materials to cook everything.%n");
        }
        System.out.printf("Liquids left: ");
        if (liquid.isEmpty()) {
            System.out.printf("none");
        } else {
            while (!liquid.isEmpty()) {
                System.out.printf("%d", liquid.poll());
                if (!liquid.isEmpty()) {
                    System.out.printf(", ");
                }
            }
        }
        System.out.printf("%n");
        System.out.printf("Ingredients left: ");
        if (ingredient.isEmpty()) {
            System.out.printf("none");
        } else {
            while (!ingredient.isEmpty()) {
                System.out.printf("%d", ingredient.poll());
                if (!ingredient.isEmpty()) {
                    System.out.printf(", ");
                }
            }
        }
        System.out.printf("%n");
        System.out.printf("Bread: %d%n", bread);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Fruit Pie: %d%n", fruitPie);
        System.out.printf("Pastry: %d%n", pastry);
    }
}
