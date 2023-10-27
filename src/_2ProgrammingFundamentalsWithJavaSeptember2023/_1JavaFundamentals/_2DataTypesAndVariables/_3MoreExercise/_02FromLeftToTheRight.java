package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._3MoreExercise;

import java.util.Scanner;

public class _02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            long leftNumber = Long.parseLong(numbers[0]);
            long rightNumber = Long.parseLong(numbers[1]);
            int sumOfNumbers = 0;
            long pickedNumber = 0;
            if (leftNumber > rightNumber) {
                pickedNumber = leftNumber;
            } else if (leftNumber <= rightNumber) {
                pickedNumber = rightNumber;
            }
            while (pickedNumber != 0) {
                long lastDigit = pickedNumber % 10;
                sumOfNumbers += lastDigit;
                pickedNumber /= 10;
            }
            System.out.printf("%d%n", Math.abs(sumOfNumbers));
        }
    }
}
