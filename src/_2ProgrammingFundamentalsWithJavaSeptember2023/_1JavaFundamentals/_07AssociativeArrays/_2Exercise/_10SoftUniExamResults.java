package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._07AssociativeArrays._2Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> studentsScore = new LinkedHashMap<>();
        Map<String, Integer> languageCounter = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("exam finished")) {
            String[] input = command.split("-");
            String username = input[0];
            String language = input[1];
            if (language.equals("banned")) {
                studentsScore.remove(username);
                break;
            }
            int point = Integer.parseInt(input[2]);
            if (!studentsScore.containsKey(username)) {
                studentsScore.put(username, point);
            } else {
                if (studentsScore.get(username) < point) {
                    studentsScore.put(username, point);
                }
            }
            if (!languageCounter.containsKey(language)) {
                languageCounter.put(language, 1);
            } else {
                languageCounter.put(language, languageCounter.get(language) + 1);
            }
            command = scanner.nextLine();
        }
        System.out.printf("Results:%n");
        studentsScore.entrySet().forEach(entry -> System.out.printf("%s | %d%n", entry.getKey(), entry.getValue()));
        System.out.printf("Submissions:%n");

        languageCounter.entrySet().forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
    }
}
