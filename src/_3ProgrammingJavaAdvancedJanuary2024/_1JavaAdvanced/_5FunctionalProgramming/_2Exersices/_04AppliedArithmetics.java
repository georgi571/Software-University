package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._2Exersices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> add = num -> num.stream().map(nums -> nums + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = num -> num.stream().map(nums -> nums * 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = num -> num.stream().map(nums -> nums - 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = num -> num.forEach(nums -> System.out.printf("%d ", nums));
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.equals("add")) {
                numbers = add.apply(numbers);
            } else if (command.equals("multiply")) {
                numbers = multiply.apply(numbers);
            } else if (command.equals("subtract")) {
                numbers = subtract.apply(numbers);
            } else if (command.equals("print")) {
                print.accept(numbers);
                System.out.printf("%n");
            }
            command = scanner.nextLine();
        }
    }
}
