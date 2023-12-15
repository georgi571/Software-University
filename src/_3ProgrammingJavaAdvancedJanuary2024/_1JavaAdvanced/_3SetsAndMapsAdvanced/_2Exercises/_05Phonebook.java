package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contacts = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("search")) {
            String[] commandParts = command.split("-");
            contacts.put(commandParts[0], commandParts[1]);
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("stop")) {
            if (contacts.containsKey(command)) {
                System.out.printf("%s -> %s%n", command, contacts.get(command));
            } else {
                System.out.printf("Contact %s does not exist.%n", command);
            }
            command = scanner.nextLine();
        }
    }
}
