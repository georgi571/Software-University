package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        int[] specialNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int detonator = specialNumbers[0];
        int power = specialNumbers[1];
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == detonator) {
                int index = numbers.indexOf(detonator);
                numbers.remove(index);
                int indexLeft = index - power;
                if (indexLeft < 0) {
                    indexLeft = 0;
                }
                int indexRight = index + power - 1;
                if (indexRight > numbers.size() - 1) {
                    indexRight = numbers.size() - 1;
                }
                for (int j = indexRight; j >= index ; j--) {
                    numbers.remove(index);
                }
                for (int j = indexLeft; j < index; j++) {
                    numbers.remove(indexLeft);
                }
                i = 0;
            }
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.printf("%d", sum);
    }
}
