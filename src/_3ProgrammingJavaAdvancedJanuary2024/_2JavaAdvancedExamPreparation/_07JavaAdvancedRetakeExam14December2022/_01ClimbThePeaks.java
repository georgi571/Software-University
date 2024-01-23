package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._07JavaAdvancedRetakeExam14December2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> portions = new ArrayDeque<>();
        List<Integer> allPortions = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allPortions.size(); i++) {
            portions.push(allPortions.get(i));
        }
        Deque<Integer> stamina = new ArrayDeque<>();
        List<Integer> allStamina = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allStamina.size(); i++) {
            stamina.offer(allStamina.get(i));
        }
        Deque<String> peaks = new ArrayDeque<>();
        peaks.offer("Vihren");
        peaks.offer("Kutelo");
        peaks.offer("Banski Suhodol");
        peaks.offer("Polezhan");
        peaks.offer("Kamenitza");
        Deque<String> peaksPassed = new ArrayDeque<>();
        while (!portions.isEmpty() && !stamina.isEmpty() && !peaks.isEmpty()) {
            int currentPortion = portions.pop();
            int currentStamina = stamina.poll();
            int sum = currentPortion + currentStamina;
            if (peaks.peek().equals("Vihren")) {
                if (sum >= 80) {
                    peaksPassed.offer(peaks.poll());
                }
            } else if (peaks.peek().equals("Kutelo")) {
                if (sum >= 90) {
                    peaksPassed.offer(peaks.poll());
                }
            } else if (peaks.peek().equals("Banski Suhodol")) {
                if (sum >= 100) {
                    peaksPassed.offer(peaks.poll());
                }
            } else if (peaks.peek().equals("Polezhan")) {
                if (sum >= 60) {
                    peaksPassed.offer(peaks.poll());
                }
            } else if (peaks.peek().equals("Kamenitza")) {
                if (sum >= 70) {
                    peaksPassed.offer(peaks.poll());
                }
            }
        }
        if (peaks.isEmpty()) {
            System.out.printf("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK%n");
        } else {
            System.out.printf("Alex failed! He has to organize his journey better next time -> @PIRINWINS%n");
        }
        if (!peaksPassed.isEmpty()) {
            System.out.printf("Conquered peaks:%n");
            while (!peaksPassed.isEmpty()) {
                System.out.printf("%s%n", peaksPassed.poll());
            }
        }
    }
}
