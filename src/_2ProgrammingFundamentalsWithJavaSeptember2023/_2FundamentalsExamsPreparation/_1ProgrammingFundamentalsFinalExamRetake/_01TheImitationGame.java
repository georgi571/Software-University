package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._1ProgrammingFundamentalsFinalExamRetake;

import java.util.Scanner;

public class _01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder newText = new StringBuilder();
        newText.append(text);
        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] commandParts = command.split("\\|");
            if (commandParts[0].equals("Move")) {
                int numberOfLettersToMove = Integer.parseInt(commandParts[1]);
                for (int i = 1; i <= numberOfLettersToMove; i++) {
                    char getLetter = newText.charAt(0);
                    newText.deleteCharAt(0);
                    newText.append(getLetter);
                }
            } else if (commandParts[0].equals("Insert")) {
                int index = Integer.parseInt(commandParts[1]);
                String charToReplace = commandParts[2];
                newText.insert(index, charToReplace);
            } else if (commandParts[0].equals("ChangeAll")) {
                char substring = commandParts[1].charAt(0);
                String replacement = commandParts[2];
                for (int i = 0; i < newText.length(); i++) {
                    if (newText.charAt(i) == substring) {
                        newText.replace(i, i+1, replacement);
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s",newText);
    }
}
