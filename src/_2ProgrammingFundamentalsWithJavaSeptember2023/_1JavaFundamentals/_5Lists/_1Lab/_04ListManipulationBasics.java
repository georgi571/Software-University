package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._1Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] currentCommands = command.split(" ");
            String commandForCheck = currentCommands[0];
            if (commandForCheck.equals("Add")) {
                int number = Integer.parseInt(currentCommands[1]);
                numbers.add(number);
            } else if (commandForCheck.equals("Remove")) {
                int number = Integer.parseInt(currentCommands[1]);
                numbers.remove(Integer.valueOf(number));
            } else if (commandForCheck.equals("RemoveAt")) {
                int index = Integer.parseInt(currentCommands[1]);
                numbers.remove(index);
            } else if (commandForCheck.equals("Insert")) {
                int number = Integer.parseInt(currentCommands[1]);
                int index = Integer.parseInt(currentCommands[2]);
                numbers.add(index, number);
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.printf("%d ", numbers.get(i));
        }
        System.out.printf("%d", numbers.get(numbers.size() - 1));
    }
}
