package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._10JavaAdvancedRegularExam25June2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Double> milk = new ArrayDeque<>();
        List<Double> allMilk = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        for (int i = 0; i < allMilk.size(); i++) {
            milk.offer(allMilk.get(i));
        }
        Deque<Double> cacao = new ArrayDeque<>();
        List<Double> allCacao = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        for (int i = 0; i < allCacao.size(); i++) {
            cacao.push(allCacao.get(i));
        }
        int milkCounter = 0;
        int darkCounter = 0;
        int bakingCounter = 0;
        double milkChocolate = 30.00;
        double darkChocolate = 50.00;
        double bakingChocolate = 100.00;
        while (!milk.isEmpty() && !cacao.isEmpty()) {
            double currentMilk = milk.poll();
            double currentCacao = cacao.pop();
            double cacaoPercentage = currentCacao / (currentCacao + currentMilk) * 100;
            if (cacaoPercentage == milkChocolate) {
                milkCounter++;
            } else if (cacaoPercentage == darkChocolate) {
                darkCounter++;
            } else if (cacaoPercentage == bakingChocolate) {
                bakingCounter++;
            } else {
                currentMilk += 10;
                milk.offer(currentMilk);
            }
        }
        if (milkCounter > 0 && darkCounter > 0 && bakingCounter > 0) {
            System.out.printf("It’s a Chocolate Time. All chocolate types are prepared.%n");
        } else {
            System.out.printf("Sorry, but you didn't succeed to prepare all types of chocolates.%n");
        }
        if (bakingCounter > 0) {
            System.out.printf("# Baking Chocolate --> %d%n", bakingCounter);
        }
        if (darkCounter > 0) {
            System.out.printf("# Dark Chocolate --> %d%n", darkCounter);
        }
        if (milkCounter > 0) {
            System.out.printf("# Milk Chocolate --> %d%n", milkCounter);
        }
    }
}
