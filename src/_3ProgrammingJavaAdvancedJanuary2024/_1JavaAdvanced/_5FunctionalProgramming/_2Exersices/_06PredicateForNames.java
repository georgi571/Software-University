package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._2Exersices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine()
                                .split(" "))
                        .collect(Collectors.toList());
        Predicate<String> check = name -> name.length() > n;
        names.removeIf(check);
        names.forEach(e -> System.out.printf("%s%n", e));
    }
}
