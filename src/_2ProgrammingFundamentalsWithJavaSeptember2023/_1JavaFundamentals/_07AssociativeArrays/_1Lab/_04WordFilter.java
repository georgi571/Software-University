package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._07AssociativeArrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(word -> word.length() % 2 == 0)
                .toArray(String[]::new);
        for (String word : words) {
            System.out.printf("%s%n", word);
        }
    }
}
