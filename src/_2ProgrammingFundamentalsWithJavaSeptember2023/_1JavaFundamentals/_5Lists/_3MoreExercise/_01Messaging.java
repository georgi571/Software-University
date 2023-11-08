package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._3MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<String> text = Arrays.stream(scanner.nextLine()
                                .split(""))
                        .collect(Collectors.toList());
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            int sumOfCurrentNumber = 0;
            while (currentNumber > 0) {
                int lastDigit = currentNumber % 10;
                sumOfCurrentNumber += lastDigit;
                currentNumber /= 10;
            }
            int textLength = text.size();
            int choosedNumber = sumOfCurrentNumber % textLength;
            String choosedLetter = text.get(choosedNumber);
            text.remove(choosedNumber);
            System.out.printf("%s", choosedLetter);
        }
    }
}
