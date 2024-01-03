package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._1Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> uppercaseWords = word -> Character.isUpperCase(word.charAt(0));
        words = words.stream().filter(uppercaseWords).collect(Collectors.toList());
        System.out.printf("%d%n", words.size());
        System.out.println(String.join("\n", words));
    }
}
