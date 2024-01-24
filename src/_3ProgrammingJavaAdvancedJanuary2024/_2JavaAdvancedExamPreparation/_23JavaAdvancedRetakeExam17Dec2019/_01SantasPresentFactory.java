package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._23JavaAdvancedRetakeExam17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class _01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> materials = new ArrayDeque<>();
        List<Integer> allMaterials = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allMaterials.size(); i++) {
            materials.push(allMaterials.get(i));
        }
        Deque<Integer> magicLevel = new ArrayDeque<>();
        List<Integer> allMagicLevel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allMagicLevel.size(); i++) {
            magicLevel.offer(allMagicLevel.get(i));
        }
        int doll = 0;
        int woodenTrain = 0;
        int teddyBear = 0;
        int bicycle = 0;
        while (!materials.isEmpty() && !magicLevel.isEmpty()) {
            if (materials.peek() == 0 || magicLevel.peek() == 0) {
                if (materials.peek() == 0) {
                    materials.pop();
                }
                if (magicLevel.peek() == 0) {
                    magicLevel.poll();
                }
            } else {
                int currentMaterial = materials.pop();
                int currentMagicLevel = magicLevel.poll();
                int result = currentMaterial * currentMagicLevel;
                if (result == 150) {
                    doll++;
                } else if (result == 250) {
                    woodenTrain++;
                } else if (result == 300) {
                    teddyBear++;
                } else if (result == 400) {
                    bicycle++;
                } else if (result < 0) {
                    result = currentMaterial + currentMagicLevel;
                    materials.push(result);
                } else {
                    currentMaterial += 15;
                    materials.push(currentMaterial);
                }
            }
        }
        if ((doll > 0 && woodenTrain > 0) || (bicycle > 0 && teddyBear > 0)) {
            System.out.printf("The presents are crafted! Merry Christmas!%n");
        } else {
            System.out.printf("No presents this Christmas!%n");
        }
        if (!materials.isEmpty()) {
            System.out.printf("Materials left: ");
            while (!materials.isEmpty()) {
                System.out.printf("%d", materials.pop());
                if (!materials.isEmpty()) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
        if (!magicLevel.isEmpty()) {
            System.out.printf("Magic left: ");
            while (!magicLevel.isEmpty()) {
                System.out.printf("%d", magicLevel.poll());
                if (!magicLevel.isEmpty()) {
                    System.out.printf(", ");
                }
            }
            System.out.printf("%n");
        }
        if (bicycle > 0) {
            System.out.printf("Bicycle: %d%n", bicycle);
        }
        if (doll > 0) {
            System.out.printf("Doll: %d%n", doll);
        }
        if (teddyBear > 0) {
            System.out.printf("Teddy bear: %d%n", teddyBear);
        }
        if (woodenTrain > 0) {
            System.out.printf("Wooden train: %d%n", woodenTrain);
        }
    }
}
