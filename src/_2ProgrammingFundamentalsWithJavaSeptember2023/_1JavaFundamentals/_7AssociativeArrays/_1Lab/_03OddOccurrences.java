package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._1Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class _03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = Arrays.stream(scanner.nextLine().split(" "))
                .map(word -> word.toLowerCase())
                .toArray(String[]::new);
        LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        String[] result = wordsMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(entry -> entry.getKey())
                .toArray(String[]::new);
        System.out.println(String.join(", ", result));
    }
}
