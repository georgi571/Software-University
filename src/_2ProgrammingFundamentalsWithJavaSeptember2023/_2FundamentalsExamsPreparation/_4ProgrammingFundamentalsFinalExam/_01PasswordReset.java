package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._4ProgrammingFundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String newText = text;
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] commandParts = command.split(" ");
            if (commandParts[0].equals("TakeOdd")) {
                String textAfterRemove = "";
                for (int i = 1; i <= newText.length() ; i++) {
                    if (i % 2 == 0) {
                        textAfterRemove += newText.charAt(i - 1);
                    }
                }
                newText = textAfterRemove;
                System.out.printf("%s%n", newText);
            } else if (commandParts[0].equals("Cut")) {
                int index = Integer.parseInt(commandParts[1]);
                int length = Integer.parseInt(commandParts[2]);
                String leftText = newText.substring(0, index);
                String rightText = newText.substring(index+length);
                newText = leftText + rightText;
                System.out.printf("%s%n", newText);
            } else if (commandParts[0].equals("Substitute")) {
                String oldSymbols = commandParts[1];
                String newSymbols = commandParts[2];
                if (newText.contains(oldSymbols)) {
                    newText = newText.replaceAll(oldSymbols, newSymbols);
                    System.out.printf("%s%n", newText);
                } else {
                    System.out.printf("Nothing to replace!%n");
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s%n",newText);
    }
}
