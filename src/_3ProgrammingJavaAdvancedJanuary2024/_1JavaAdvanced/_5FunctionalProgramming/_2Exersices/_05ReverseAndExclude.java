package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._2Exersices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        Collections.reverse(numbers);
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> check = num -> num % n == 0;
        numbers.removeIf(check);
        numbers.forEach(e -> System.out.printf("%d ", e));
    }
}
