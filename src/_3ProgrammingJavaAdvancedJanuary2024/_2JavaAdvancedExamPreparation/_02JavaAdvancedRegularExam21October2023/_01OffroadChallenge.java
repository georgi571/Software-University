package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._02JavaAdvancedRegularExam21October2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> fuel = new ArrayDeque<>();
        List<Integer> allFuel = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        for (int i = 0; i < allFuel.size(); i++) {
            fuel.push(allFuel.get(i));
        }
        Deque<Integer> consumption = new ArrayDeque<>();
        List<Integer> allConsumption = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allConsumption.size(); i++) {
            consumption.offer(allConsumption.get(i));
        }
        Deque<Integer> neededFuel = new ArrayDeque<>();
        List<Integer> allNeededFuel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allNeededFuel.size(); i++) {
            neededFuel.offer(allNeededFuel.get(i));
        }
        int reachAltitude = 1;
        while (!fuel.isEmpty()) {
            if (fuel.pop() - consumption.poll() >= neededFuel.poll()) {
                System.out.printf("John has reached: Altitude %d%n", reachAltitude++);
                if (reachAltitude - 1 == allNeededFuel.size()) {
                    break;
                }
            } else {
                System.out.printf("John did not reach: Altitude %d%n", reachAltitude--);
                break;
            }
        }
        if (reachAltitude < allFuel.size()) {
            if (reachAltitude == 0) {
                System.out.printf("John failed to reach the top.%n");
                System.out.printf("John didn't reach any altitude.%n");
            } else {
                System.out.printf("John failed to reach the top.%n");
                System.out.printf("Reached altitudes: ");
                for (int i = 1; i < reachAltitude; i++) {
                    System.out.printf("Altitude %d, ", i);
                }
                System.out.printf("Altitude %d%n", reachAltitude);
            }
        }

        if (reachAltitude - 1 == allNeededFuel.size()) {
            System.out.printf("John has reached all the altitudes and managed to reach the top!%n");
        }
    }
}
