package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstNumbers = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();
        int[] secondNumbers = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();
        boolean isIdentical = true;
        int sum = 0;
        for (int i = 0; i < firstNumbers.length; i++) {
            sum += firstNumbers[i];
            if (firstNumbers[i] != secondNumbers[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.%n", i);
                isIdentical = false;
                break;
            }
        }
        if (isIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
