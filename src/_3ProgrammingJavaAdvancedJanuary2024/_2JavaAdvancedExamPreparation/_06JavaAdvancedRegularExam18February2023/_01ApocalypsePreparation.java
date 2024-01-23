package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._06JavaAdvancedRegularExam18February2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> textiles = new ArrayDeque<>();
        List<Integer> allTextiles = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allTextiles.size(); i++) {
            textiles.offer(allTextiles.get(i));
        }
        Deque<Integer> medicaments = new ArrayDeque<>();
        List<Integer> allMedicaments = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allMedicaments.size(); i++) {
            medicaments.push(allMedicaments.get(i));
        }
        int patch = 0;
        int bandage = 0;
        int medKit = 0;
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int currentTextiles = textiles.poll();
            int currentMedicaments = medicaments.pop();
            int sum = currentTextiles + currentMedicaments;
            if (sum == 30) {
                patch++;
            } else if (sum == 40) {
                bandage++;
            } else if (sum == 100) {
                medKit++;
            } else if (sum > 100) {
                medKit++;
                int nextMedicaments = medicaments.pop();
                nextMedicaments += sum - 100;
                medicaments.push(nextMedicaments);
            } else {
                currentMedicaments += 10;
                medicaments.push(currentMedicaments);
            }
        }
        Map<String, Integer> medicament = new TreeMap<>();
        if (patch > 0) {
            medicament.put("Patch", patch);
        }
        if (bandage > 0) {
            medicament.put("Bandage", bandage);
        }
        if (medKit > 0) {
            medicament.put("MedKit", medKit);
        }
        if (textiles.isEmpty() && !medicaments.isEmpty()) {
            System.out.printf("Textiles are empty.%n");
        } else if (!textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.printf("Medicaments are empty.%n");
        } else {
            System.out.printf("Textiles and medicaments are both empty.%n");
        }
        medicament.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                });
        if (!medicaments.isEmpty()) {
            System.out.printf("Medicaments left: ");
            while (!medicaments.isEmpty()) {
                System.out.printf("%d", medicaments.pop());
                if (!medicaments.isEmpty()) {
                    System.out.printf(", ");
                }
            }
        }
        if (!textiles.isEmpty()) {
            System.out.printf("Textiles left: ");
            while (!textiles.isEmpty()) {
                System.out.printf("%d", textiles.poll());
                if (!textiles.isEmpty()) {
                    System.out.printf(", ");
                }
            }
        }
    }
}
