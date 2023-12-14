package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._1Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                        .collect(Collectors.toList());
        for (int i = 0; i < numbers.size() && i < 3; i++) {
            System.out.printf("%d ", numbers.get(i));
        }
    }
}
