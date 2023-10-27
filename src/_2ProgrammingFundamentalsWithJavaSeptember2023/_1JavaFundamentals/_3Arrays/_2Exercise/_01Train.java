package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._2Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfTrain = Integer.parseInt(scanner.nextLine());
        int[] train = new int[numbersOfTrain];
        int totalSum = 0;
        for (int i = 0; i < numbersOfTrain; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
            totalSum += train[i];
            System.out.print(train[i]+ " ");
        }
        System.out.printf("%n%d", totalSum);
    }
}
