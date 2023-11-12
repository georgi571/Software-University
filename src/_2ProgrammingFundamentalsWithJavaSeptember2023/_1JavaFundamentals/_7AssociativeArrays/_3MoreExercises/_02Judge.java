package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._3MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class _02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, Integer>> judgeContest = new LinkedHashMap<>();
        Map<String, Integer> individualPoints = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("no more time")) {
            String[] commandParts = command.split(" -> ");
            String username = commandParts[0];
            String contest = commandParts[1];
            int points = Integer.parseInt(commandParts[2]);
            TreeMap<String, Integer> userResult = new TreeMap<>();
            userResult.put(username, points);
            if (!judgeContest.containsKey(contest)) {
                judgeContest.put(contest, userResult);
                if (!individualPoints.containsKey(username)) {
                    individualPoints.put(username, points);
                } else {
                    individualPoints.put(username, individualPoints.get(username) + points);
                }
            } else {
                if (!judgeContest.get(contest).containsKey(username)){
                    judgeContest.get(contest).put(username, points);
                    if (!individualPoints.containsKey(username)) {
                        individualPoints.put(username, points);
                    } else {
                        individualPoints.put(username, individualPoints.get(username) + points);
                    }
                } else {
                    if (points > judgeContest.get(contest).get(username)) {
                        int diff = points - judgeContest.get(contest).get(username);
                        individualPoints.put(username, individualPoints.get(username) + diff);
                    }
                    judgeContest.get(contest).put(username, Math.max(points,judgeContest.get(contest).get(username)));
                }
            }
            command = scanner.nextLine();
        }
        judgeContest.entrySet().forEach(entry -> {
            int counterUsers = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                counterUsers++;
            }
            System.out.printf("%s: %d participants%n", entry.getKey(), counterUsers);
            AtomicInteger number = new AtomicInteger(0);
            entry.getValue().entrySet().stream().sorted((score1, score2)->score2.getValue() - score1.getValue()).forEach(i -> {
                number.getAndIncrement();
                System.out.printf("%s. %s <::> %d%n", number, i.getKey(), i.getValue());
            });
        });
        System.out.printf("Individual standings:%n");
        AtomicInteger number = new AtomicInteger(0);
        individualPoints.entrySet().stream().sorted((score1, score2)->score2.getValue() - score1.getValue()).forEach(entry -> {
            number.getAndIncrement();
            System.out.printf("%s. %s -> %d%n", number, entry.getKey(), entry.getValue());
        });
    }
}
