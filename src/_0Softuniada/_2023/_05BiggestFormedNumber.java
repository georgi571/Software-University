package _0Softuniada._2023;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _05BiggestFormedNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.asList(scanner.nextLine().split("\\s+"));
        Collections.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            result.append(number);
        }
        System.out.printf("%s",result);
    }
}