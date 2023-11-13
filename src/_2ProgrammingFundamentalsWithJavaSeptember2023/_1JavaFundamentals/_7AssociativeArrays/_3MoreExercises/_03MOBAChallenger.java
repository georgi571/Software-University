package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._3MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> players = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Season end")) {
            if (command.contains("->")) {
                String[] commandParts = command.split(" -> ");
                String player = commandParts[0];
                String position = commandParts[1];
                int skill = Integer.parseInt(commandParts[2]);
                LinkedHashMap<String, Integer> positionSkill = new LinkedHashMap<>();
                positionSkill.put(position, skill);
                if (players.containsKey(player)) {
                    if (!players.get(player).containsKey(position)) {
                        players.get(player).put(position, skill);
                    } else {
                        if (players.get(player).get(position) < skill) {
                            players.get(player).put(position, skill);
                        }
                    }
                } else {
                    players.put(player, positionSkill);
                }
            } else {
                String[] commandParts = command.split(" ");
                String player1 = commandParts[0];
                String player2 = commandParts[2];
                if (players.containsKey(player1) && players.containsKey(player2)) {
                    String removePlayer = "";
                    for (String p1 : players.get(player1).keySet()) {
                        for (String p2 : players.get(player2).keySet()) {
                            if (p1.equals(p2)) {
                                int p1Points = players.get(player1).values().stream().mapToInt(i -> i).sum();
                                int p2Points = players.get(player2).values().stream().mapToInt(i -> i).sum();
                                if (p1Points > p2Points) {
                                    removePlayer = player2;
                                } else if (p1Points < p2Points) {
                                    removePlayer = player1;
                                }
                            }
                        }
                    }
                    players.remove(removePlayer);
                }
            }
            command = scanner.nextLine();
        }
        players.entrySet().stream().sorted((p1, p2) -> {
            int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                    p1.getValue().values().stream().mapToInt(i -> i).sum());
            if (result == 0) {
                result = p1.getKey().compareTo(p2.getKey());
            }
            return result;
        }).forEach(entry -> {
            int sum = entry.getValue().values().stream().mapToInt(i -> i).sum();
            System.out.printf("%s: %d skill%n", entry.getKey(), sum);
            entry.getValue().entrySet().stream().sorted((f, s) -> {
                int res = Integer.compare(s.getValue(), f.getValue());
                if (res == 0) {
                    res = f.getKey().compareTo(s.getKey());
                }
                return res;
            }).forEach(role -> {
                System.out.printf("- %s <::> %d%n",role.getKey(), role.getValue());
            });
        });
    }
}
