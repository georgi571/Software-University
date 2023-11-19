package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._1ProgrammingFundamentalsFinalExamRetake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, String>> songs = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];
            Map<String, String> composerKey = new LinkedHashMap<>();
            composerKey.put(composer, key);
            songs.put(piece, composerKey);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandParts = command.split("\\|");
            if (commandParts[0].equals("Add")) {
                String piece = commandParts[1];
                String composer = commandParts[2];
                String key = commandParts[3];
                if (!songs.containsKey(piece)) {
                    Map<String, String> composerKey = new LinkedHashMap<>();
                    composerKey.put(composer, key);
                    songs.put(piece, composerKey);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                } else {
                    System.out.printf("%s is already in the collection!%n", piece);
                }
            } else if (commandParts[0].equals("Remove")) {
                String piece = commandParts[1];
                if (songs.containsKey(piece)) {
                    songs.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            } else if (commandParts[0].equals("ChangeKey")) {
                String piece = commandParts[1];
                String newKey = commandParts[2];
                if (songs.containsKey(piece)) {
                    songs.entrySet().forEach(entry -> {
                        if (entry.getKey().contains(piece)) {
                            entry.getValue().entrySet().forEach(entry2 -> {
                                songs.get(piece).put(entry2.getKey(), newKey);
                            });
                        }
                    });
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            }
            command = scanner.nextLine();
        }
        songs.entrySet().forEach(entry -> {
            entry.getValue().entrySet().forEach(entry2 -> {
                System.out.printf("%s -> Composer: %s, Key: %s%n",entry.getKey(), entry2.getKey(), entry2.getValue());
            });
        });
    }
}
