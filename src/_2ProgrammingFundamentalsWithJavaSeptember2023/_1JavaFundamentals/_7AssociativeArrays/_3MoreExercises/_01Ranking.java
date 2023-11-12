package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._3MoreExercises;

import java.util.*;

public class _01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, String> contestPasswords = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        while (!command.equals("end of contests")) {
            String[] contests = command.split(":");
            String contest = contests[0];
            String password = contests[1];
            contestPasswords.put(contest, password);
            command = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!input.equals("end of submissions")) {
            String[] submissions = input.split("=>");
            String contest = submissions[0];
            String password = submissions[1];
            String username = submissions[2];
            int points = Integer.parseInt(submissions[3]);
            if (contestPasswords.containsKey(contest)) {
                if (contestPasswords.get(contest).equals(password)) {
                    LinkedHashMap<String, Integer> courseGrade = new LinkedHashMap<>();
                    courseGrade.put(contest, points);
                    if (!users.containsKey(username)) {
                        users.put(username, courseGrade);
                    } else {
                        if (!users.get(username).containsKey(contest)) {
                            users.get(username).put(contest, points);
                        } else {
                            users.get(username).put(contest, Math.max(points, users.get(username).get(contest)));
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        int totalSum = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %s points.%n", user.getKey(), totalSum);
            }
        }
        System.out.printf("Ranking: %n");
        users.entrySet().forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());
                    entry.getValue().entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue())
                            .forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
                });
    }
}
