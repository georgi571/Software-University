package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._3ProgrammingFundamentalsFinalExamRetake;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder();
        String concealedMessage = scanner.nextLine();
        message.append(concealedMessage);
        String command = scanner.nextLine();
        while (!command.equals("Reveal")) {
            String[] commandParts = command.split(":\\|:");
            if (commandParts[0].equals("InsertSpace")) {
                int index = Integer.parseInt(commandParts[1]);
                message.insert(index, " ");
                System.out.printf("%s%n", message);
            } else if (commandParts[0].equals("Reverse")) {
                String substring = commandParts[1];
                if (message.toString().contains(substring)) {
                    int index = message.indexOf(substring);
                    message.delete(message.indexOf(substring), message.indexOf(substring) + substring.length());
                    String newText = "";
                    for (int i = substring.length() - 1; i >= 0 ; i--) {
                        newText += substring.charAt(i);
                    }
                    message.append(newText);
                    System.out.printf("%s%n", message);
                } else {
                    System.out.printf("error%n");
                }
            } else if (commandParts[0].equals("ChangeAll")) {
                String substring = commandParts[1];
                String replacement = commandParts[2];
                String updatedMessage = Pattern.compile(substring).matcher(message).replaceAll(replacement);
                message.replace(0, message.length(), updatedMessage);
                System.out.printf("%s%n", message);
            }
            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", message);
    }
}
