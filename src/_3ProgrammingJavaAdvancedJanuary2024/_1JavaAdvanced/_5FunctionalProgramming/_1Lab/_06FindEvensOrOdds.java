package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._1Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        Predicate<Integer> evenOrOdd = number -> number % 2 == 0;
        if (command.equals("odd")) {
            for (int i = numbers.get(0); i <= numbers.get(1) ; i++) {
                if (!evenOrOdd.test(i)) {
                    System.out.printf("%d ", i);
                }
            }
        } if (command.equals("even")) {
            for (int i = numbers.get(0); i <= numbers.get(1) ; i++) {
                if (evenOrOdd.test(i)) {
                    System.out.printf("%d ", i);
                }
            }
        }
    }
}
