package _2ProgrammingFundamentalsWithJavaSeptember2023._4FinalExam._1MainExam;

import java.util.Scanner;

public class _01PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        StringBuilder newPassword = new StringBuilder();
        newPassword.append(password);
        String command = scanner.nextLine();
        while (!command.equals("Complete")) {
            String[] commandParts = command.split("\\s+");
            if (commandParts[0].equals("Make")) {
                if (commandParts[1].equals("Upper")) {
                    int index = Integer.parseInt(commandParts[2]);
                    char getChar = newPassword.charAt(index);
                    char newChar = (char) (getChar - 32);
                    newPassword.replace(index, index+1, String.valueOf(newChar));
                    System.out.printf("%s%n", newPassword);
                } else if (commandParts[1].equals("Lower")) {
                    int index = Integer.parseInt(commandParts[2]);
                    char getChar = newPassword.charAt(index);
                    char newChar = (char) (getChar + 32);
                    newPassword.replace(index, index+1, String.valueOf(newChar));
                    System.out.printf("%s%n", newPassword);
                }
            } else if (commandParts[0].equals("Insert")) {
                int index = Integer.parseInt(commandParts[1]);
                char currentChar = commandParts[2].charAt(0);
                if (index >= 0 && index < newPassword.length()) {
                    newPassword.insert(index, currentChar);
                    System.out.printf("%s%n", newPassword);
                }
            } else if (commandParts[0].equals("Replace")) {
                char currentChar = commandParts[1].charAt(0);
                int value = Integer.parseInt(commandParts[2]);
                int newValueOfCurrentChar = (int) currentChar + value;
                char newChar = (char) newValueOfCurrentChar;
                StringBuilder newText = new StringBuilder();
                for (int i = 0; i < newPassword.length(); i++) {
                    if (newPassword.charAt(i) == currentChar) {
                        newText.append(newChar);
                    } else {
                        newText.append(newPassword.charAt(i));
                    }
                }
                newPassword = newText;
                System.out.printf("%s%n", newPassword);
            } else if (commandParts[0].equals("Validation")) {
                if (newPassword.length() < 8) {
                    System.out.printf("Password must be at least 8 characters long!%n");
                }
                for (int i = 0; i < newPassword.length(); i++) {
                    if (Character.isLetterOrDigit(newPassword.charAt(i)) || newPassword.charAt(i) == '_') {

                    } else {
                        System.out.printf("Password must consist only of letters, digits and _!%n");
                        break;
                    }
                }
                int lowerCounter = 0;
                int upperCounter = 0;
                int digitCounter = 0;
                for (int i = 0; i < newPassword.length(); i++) {
                    if (Character.isLowerCase(newPassword.charAt(i))) {
                        lowerCounter++;
                    }
                    if (Character.isUpperCase(newPassword.charAt(i))) {
                        upperCounter++;
                    }
                    if (Character.isDigit(newPassword.charAt(i))) {
                        digitCounter++;
                    }
                }
                if (upperCounter == 0) {
                    System.out.printf("Password must consist at least one uppercase letter!%n");
                }
                if (lowerCounter == 0) {
                    System.out.printf("Password must consist at least one lowercase letter!%n");
                }
                if (digitCounter == 0) {
                    System.out.printf("Password must consist at least one digit!%n");
                }
            }
            command = scanner.nextLine();
        }
    }
}
