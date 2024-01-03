package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._2Exersices;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
        Function<Integer[], Integer> findSmallestNumbers = arr -> Arrays.stream(arr).mapToInt(e -> e).min().getAsInt();
        int smallestNumber = findSmallestNumbers.apply(numbers);
        System.out.printf("%d", smallestNumber);
    }
}
