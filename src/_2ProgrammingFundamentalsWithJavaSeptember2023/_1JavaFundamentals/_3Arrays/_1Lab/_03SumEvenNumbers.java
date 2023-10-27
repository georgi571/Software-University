package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();
        int counter = 0;
        for (int i = 0; i < numbers.length ; i++) {
            if (numbers[i] % 2 == 0) {
                counter += numbers[i];
            }
        }
        System.out.printf("%d", counter);
    }
}
