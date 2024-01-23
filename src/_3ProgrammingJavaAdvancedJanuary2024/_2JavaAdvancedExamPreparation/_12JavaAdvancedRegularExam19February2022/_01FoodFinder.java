package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._12JavaAdvancedRegularExam19February2022;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class _01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Character> vowels = new ArrayDeque<>();
        List<String> allVowels = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        for (int i = 0; i < allVowels.size(); i++) {
            vowels.offer(allVowels.get(i).charAt(0));
        }
        Deque<Character> consonants = new ArrayDeque<>();
        List<String> allconsonants = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        for (int i = 0; i < allconsonants.size(); i++) {
            consonants.push(allconsonants.get(i).charAt(0));
        }
        List<String> words = List.of("pear", "flour", "pork", "olive");
        Map<Character, Integer> pear = new LinkedHashMap<>();
        Map<Character, Integer> flour = new LinkedHashMap<>();
        Map<Character, Integer> pork = new LinkedHashMap<>();
        Map<Character, Integer> olive = new LinkedHashMap<>();
        for (int i = 0; i < words.size(); i++) {
            char[] currentWords = words.get(i).toCharArray();
            if (i == 0) {
                for (int j = 0; j < currentWords.length; j++) {
                    pear.put(currentWords[j], 0);
                }
            } else if (i == 1) {
                for (int j = 0; j < currentWords.length; j++) {
                    flour.put(currentWords[j], 0);
                }
            } else if (i == 2) {
                for (int j = 0; j < currentWords.length; j++) {
                    pork.put(currentWords[j], 0);
                }
            } else if (i == 3) {
                for (int j = 0; j < currentWords.length; j++) {
                    olive.put(currentWords[j], 0);
                }
            }
        }
        int pearCounter = 0;
        int flourCounter = 0;
        int porkCounter = 0;
        int oliveCounter = 0;
        while (!consonants.isEmpty()) {
            char currentVowels = vowels.poll();
            char currentConsonants = consonants.pop();
            AtomicInteger currentPear = new AtomicInteger();
            pear.entrySet().forEach(entry -> {
                if (entry.getKey() == currentVowels || entry.getKey() == currentConsonants) {
                    pear.put(entry.getKey(), pear.get(entry.getKey()) + 1);
                }
                if (entry.getValue() > 0) {
                    currentPear.getAndIncrement();
                }
            });
            if (currentPear.get() == 4) {
                pearCounter++;
            }
            AtomicInteger currentFlour = new AtomicInteger();
            flour.entrySet().forEach(entry -> {
                if (entry.getKey() == currentVowels || entry.getKey() == currentConsonants) {
                    flour.put(entry.getKey(), flour.get(entry.getKey()) + 1);
                }
                if (entry.getValue() > 0) {
                    currentFlour.getAndIncrement();
                }
            });
            if (currentFlour.get() == 5) {
                flourCounter++;
            }
            AtomicInteger currentPork = new AtomicInteger();
            pork.entrySet().forEach(entry -> {
                if (entry.getKey() == currentVowels || entry.getKey() == currentConsonants) {
                    pork.put(entry.getKey(), pork.get(entry.getKey()) + 1);
                }
                if (entry.getValue() > 0) {
                    currentPork.getAndIncrement();
                }
            });
            if (currentPork.get() == 4) {
                porkCounter++;
            }
            AtomicInteger currentOlive = new AtomicInteger();
            olive.entrySet().forEach(entry -> {
                if (entry.getKey() == currentVowels || entry.getKey() == currentConsonants) {
                    olive.put(entry.getKey(), olive.get(entry.getKey()) + 1);
                }
                if (entry.getValue() > 0) {
                    currentOlive.getAndIncrement();
                }
            });
            if (currentOlive.get() == 5) {
                oliveCounter++;
            }
            vowels.offer(currentVowels);
        }
        int totalWords = 0;
        if (pearCounter > 0) {
            totalWords++;
        }
        if (flourCounter > 0) {
            totalWords++;
        }
        if (porkCounter > 0) {
            totalWords++;
        }
        if (oliveCounter > 0) {
            totalWords++;
        }
        System.out.printf("Words found: %d%n", totalWords);
        if (pearCounter > 0) {
            System.out.printf("pear%n");
        }
        if (flourCounter > 0) {
            System.out.printf("flour%n");
        }
        if (porkCounter > 0) {
            System.out.printf("pork%n");
        }
        if (oliveCounter > 0) {
            System.out.printf("olive%n");
        }
    }
}
