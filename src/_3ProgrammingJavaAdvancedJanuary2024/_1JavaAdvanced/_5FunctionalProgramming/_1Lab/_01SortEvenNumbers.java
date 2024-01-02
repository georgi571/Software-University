package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._1Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList());
        printList(numbers);
        Collections.sort(numbers);
        printList(numbers);
    }
    private static void printList(List<Integer> numbers) {
        List<String> numbersAsText = new ArrayList<>();
        for (Integer number : numbers) {
            numbersAsText.add(String.valueOf(number));
        }
        System.out.println(String.join(", ", numbersAsText));
    }
}
