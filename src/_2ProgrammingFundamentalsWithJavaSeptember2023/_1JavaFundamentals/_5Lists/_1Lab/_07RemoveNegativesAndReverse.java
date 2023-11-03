package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._1Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0) {
                numbers.remove(i);
                i -= 1;
            }
        }
        if (numbers.size() > 0) {
            Collections.reverse(numbers);
            for (int i = 0; i < numbers.size() - 1; i++) {
                System.out.printf("%d ", numbers.get(i));
            }
            System.out.printf("%d", numbers.get(numbers.size() - 1));
        } else {
            System.out.printf("empty");
        }
    }
}
