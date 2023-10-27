package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._1.ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine()
                                .split(" "))
                        .collect(Collectors.toList());
        int numberOfTurns = 0;
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            numberOfTurns += 1;
            int[] indexForElement = Arrays.stream(command.split(" "))
                            .mapToInt(e -> Integer.parseInt(e))
                            .toArray();
            if (indexForElement[0] >= 0 && indexForElement[0] <= elements.size() - 1 && indexForElement[1] >= 0 && indexForElement[1] <= elements.size() - 1 && indexForElement[0] != indexForElement[1]) {
                String elementOnIndex1 = elements.get(indexForElement[0]);
                String elementOnIndex2 = elements.get(indexForElement[1]);
                if (elementOnIndex1.equals(elementOnIndex2)) {
                    if (indexForElement[0] > indexForElement[1]) {
                        elements.remove(indexForElement[0]);
                        elements.remove(indexForElement[1]);
                    } else {
                        elements.remove(indexForElement[1]);
                        elements.remove(indexForElement[0]);
                    }
                    System.out.printf("Congrats! You have found matching elements - %s!%n", elementOnIndex1);
                } else {
                    System.out.printf("Try again!%n");
                }
            } else {
                int middleOfList = elements.size() / 2;
                elements.add(middleOfList, "-" + numberOfTurns + "a");
                elements.add(middleOfList, "-" + numberOfTurns + "a");
                System.out.printf("Invalid input! Adding additional elements to the board%n");
            }
            if (elements.size() == 0) {
                System.out.printf("You have won in %d turns!", numberOfTurns);
                break;
            }
            command = scanner.nextLine();
        }
        if (elements.size() > 0) {
            System.out.printf("Sorry you lose :(%n");
        }
        for (String element : elements) {
            System.out.printf("%s ", element);
        }
    }
}
