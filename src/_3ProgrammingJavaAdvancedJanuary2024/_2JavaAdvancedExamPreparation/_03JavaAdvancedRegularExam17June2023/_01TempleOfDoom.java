package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._03JavaAdvancedRegularExam17June2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> tools = new ArrayDeque<>();
        List<Integer> allTools = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allTools.size(); i++) {
            tools.offer(allTools.get(i));
        }
        Deque<Integer> substances = new ArrayDeque<>();
        List<Integer> allSubstances = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allSubstances.size(); i++) {
            substances.push(allSubstances.get(i));
        }
        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while (!tools.isEmpty() && !substances.isEmpty() && !challenges.isEmpty()) {
            int currentTool = tools.poll();
            int currentSubstance = substances.pop();
            int multiplyValue = currentTool * currentSubstance;
            if (challenges.contains(multiplyValue)) {
                challenges.remove(challenges.indexOf(multiplyValue));
            } else {
                currentTool++;
                currentSubstance--;
                tools.offer(currentTool);
                if (currentSubstance > 0) {
                    substances.push(currentSubstance);
                }
            }
        }
        if (tools.isEmpty() || substances.isEmpty()) {
            if (!challenges.isEmpty()) {
                System.out.printf("Harry is lost in the temple. Oblivion awaits him.%n");
            } else {
                System.out.printf("Harry found an ostracon, which is dated to the 6th century BCE.%n");
            }
        }
        if (!tools.isEmpty()) {
            System.out.printf("Tools: ");
            while (!tools.isEmpty()) {
                System.out.printf("%d", tools.poll());
                if (!tools.isEmpty()) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
        if (!substances.isEmpty()) {
            List<Integer> substancesList = new ArrayList<>();
            while (!substances.isEmpty()) {
                substancesList.add(substances.pop());
            }
            System.out.printf("Substances: ");
            for (int i = 0; i < substancesList.size(); i++) {
                System.out.printf("%d",substancesList.get(i));
                if (i < substancesList.size() - 1) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
        if (!challenges.isEmpty()) {
            System.out.printf("Challenges: ");
        }
        for (int i = 0; i < challenges.size(); i++) {
            System.out.printf("%d",challenges.get(i));
            if (i < challenges.size() - 1) {
                System.out.printf(", ");
            }
        }
        System.out.printf("%n");
    }
}
