package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._04JavaAdvancedRetakeExam9August2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> armor = new ArrayDeque<>();
        List<Integer> allArmor = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allArmor.size(); i++) {
            armor.offer(allArmor.get(i));
        }
        Deque<Integer> strike = new ArrayDeque<>();
        List<Integer> allStrike = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allStrike.size(); i++) {
            strike.push(allStrike.get(i));
        }
        while (!armor.isEmpty() && !strike.isEmpty()) {
            int currentArmor = armor.poll();
            int currentStrike = strike.pop();
            if (currentStrike >= currentArmor) {
                currentStrike -= currentArmor;
                if (currentStrike > 0) {
                    if (!strike.isEmpty()) {
                        currentStrike += strike.pop();
                    }
                    strike.push(currentStrike);
                }
            } else {
                currentArmor -= currentStrike;
                armor.offer(currentArmor);
            }
        }
        if (armor.isEmpty()) {
            System.out.printf("All monsters have been killed!%n");
        }
        if (strike.isEmpty()) {
            System.out.printf("The soldier has been defeated.%n");
        }
        System.out.printf("Total monsters killed: %d%n", allArmor.size() - armor.size());
    }
}
