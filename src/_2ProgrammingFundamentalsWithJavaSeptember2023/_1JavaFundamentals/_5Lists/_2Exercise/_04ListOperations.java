package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] input = command.split(" ");
            String currentCommand = input[0];
            if (currentCommand.equals("Add")) {
                int number = Integer.parseInt(input[1]);
                numbers.add(number);
            } else if (currentCommand.equals("Insert")) {
                int number = Integer.parseInt(input[1]);
                int index = Integer.parseInt(input[2]);
                if (index >= 0 && index <= numbers.size() - 1) {
                    numbers.add(index, number);
                } else {
                    System.out.printf("Invalid index%n");
                }
            } else if (currentCommand.equals("Remove")) {
                int index = Integer.parseInt(input[1]);
                if (index >= 0 && index <= numbers.size() - 1) {
                    numbers.remove(index);
                } else {
                    System.out.printf("Invalid index%n");
                }
            } else if (currentCommand.equals("Shift")) {
                String side = input[1];
                int count = Integer.parseInt(input[2]);
                if (side.equals("left")) {
                    for (int i = 1; i <= count ; i++) {
                        int currentNumber = numbers.get(0);
                        numbers.remove(0);
                        numbers.add(currentNumber);
                    }
                } else if (side.equals("right")) {
                    for (int i = 1; i <= count ; i++) {
                        int currentNumber = numbers.get(numbers.size() - 1);
                        numbers.remove(numbers.size() - 1);
                        numbers.add(0, currentNumber);
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < numbers.size() - 1 ; i++) {
            System.out.printf("%d ", numbers.get(i));
        }
        System.out.printf("%d", numbers.get(numbers.size() - 1));
    }
}
