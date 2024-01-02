package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._1Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int countNumbers = numbers.size();
        Function<List<Integer>, Integer> sumOfNumbersInList = list -> {
            int sum = 0;
            for (Integer number : list) {
                sum += number;
            }
            return sum;
        };
        int sumOfNumbers = sumOfNumbersInList.apply(numbers);
        System.out.printf("Count = %d%n", countNumbers);
        System.out.printf("Sum = %d%n", sumOfNumbers);
    }
}
