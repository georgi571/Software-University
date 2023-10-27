package _2ProgrammingFundamentalsWithJavaSeptember2023._3MidExam._1MainExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(e -> Integer.parseInt(e))
                        .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            String[] currentCommand = command.split(" ");
            String recievedCommand = currentCommand[0];
            int value = Integer.parseInt(currentCommand[1]);
            if (recievedCommand.equals("Add")) {
                numbers.add(value);
            } else if (recievedCommand.equals("Remove")) {
                int indexOfValue = numbers.indexOf(value);
                numbers.remove(indexOfValue);
            } else if (recievedCommand.equals("Replace")) {
                if (numbers.contains(value)) {
                    int replacement = Integer.parseInt(currentCommand[2]);
                    int indexOfValue = numbers.indexOf(value);
                    numbers.remove(indexOfValue);
                    numbers.add(indexOfValue, replacement);
                }
            } else if (recievedCommand.equals("Collapse")) {
                for (int i = 0; i < numbers.size(); i++) {
                    int currentNumberValue = numbers.get(i);
                    int indexOfValue = numbers.indexOf(currentNumberValue);
                    if (currentNumberValue < value) {
                        numbers.remove(indexOfValue);
                        i -= 1;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.printf("%d ", numbers.get(i));
        }
        System.out.printf("%d", numbers.get(numbers.size() - 1));
    }
}

