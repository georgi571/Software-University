package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._1Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] input = command.split(" ");
            String listCommands = input[0];
            if (listCommands.equals("Contains")) {
                int number = Integer.parseInt(input[1]);
                boolean isNumberExist = false;
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == number) {
                        System.out.printf("Yes%n");
                        isNumberExist = true;
                        break;
                    }
                }
                if (!isNumberExist) {
                    System.out.printf("No such number%n");
                }
            } else if (listCommands.equals("Print")) {
                String evenOrOdd = input[1];
                List<Integer> evenOrOddList = new ArrayList<>();
                if (evenOrOdd.equals("even")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 == 0) {
                            evenOrOddList.add(numbers.get(i));
                        }
                    }
                } else {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 == 1) {
                            evenOrOddList.add(numbers.get(i));
                        }
                    }
                }
                for (int i = 0; i < evenOrOddList.size() - 1; i++) {
                    System.out.printf("%d ", evenOrOddList.get(i));
                }
                System.out.printf("%d%n", evenOrOddList.get(evenOrOddList.size() - 1));
            } else if (listCommands.equals("Get")) {
                int sum = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    sum += numbers.get(i);
                }
                System.out.printf("%d%n",sum);
            } else if (listCommands.equals("Filter")) {
                String condition = input[1];
                int number = Integer.parseInt(input[2]);
                List<Integer> conditionList = new ArrayList<>();
                if (condition.equals("<")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < number) {
                            conditionList.add(numbers.get(i));
                        }
                    }
                } else if (condition.equals(">")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) > number) {
                            conditionList.add(numbers.get(i));
                        }
                    }
                } else if (condition.equals(">=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) >= number) {
                            conditionList.add(numbers.get(i));
                        }
                    }
                } else if (condition.equals("<=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= number) {
                            conditionList.add(numbers.get(i));
                        }
                    }
                }
                for (int i = 0; i < conditionList.size() - 1; i++) {
                    System.out.printf("%d ", conditionList.get(i));
                }
                System.out.printf("%d%n", conditionList.get(conditionList.size() - 1));
            }
            command = scanner.nextLine();
        }
    }
}
