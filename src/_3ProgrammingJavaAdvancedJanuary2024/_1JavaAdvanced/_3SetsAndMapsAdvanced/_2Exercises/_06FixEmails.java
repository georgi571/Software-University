package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contacts = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.contains(".us") && !email.contains(".uk") && !email.contains(".com")) {
                contacts.put(command, email);
            }
            command = scanner.nextLine();
        }
        contacts.entrySet().forEach(entry -> {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        });
    }
}
