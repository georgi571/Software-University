package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.*;

public class _10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<Integer, TreeSet<String>>> users = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String ip = commandParts[0];
            String name = commandParts[1];
            int duration = Integer.parseInt(commandParts[2]);
            if (users.containsKey(name)) {
                users.get(name).entrySet().forEach(entry -> {
                    Map<Integer, TreeSet<String>> durations = new TreeMap<>();
                    int newDuration = entry.getKey() + duration;
                    TreeSet<String> oldIps = entry.getValue();
                    oldIps.add(ip);
                    durations.put(newDuration, oldIps);
                    users.replace(name, users.get(name), durations);
                });
            } else {
                Map<Integer, TreeSet<String>> durations = new TreeMap<>();
                TreeSet<String> ips = new TreeSet<>();
                ips.add(ip);
                durations.put(duration, ips);
                users.put(name, durations);
            }
        }
        users.entrySet().forEach(entry -> {
            entry.getValue().entrySet().forEach(entry2 -> {
                System.out.printf("%s: %d [%s]%n",entry.getKey(), entry2.getKey(), String.join(", ", entry2.getValue()));
            });
        });
    }
}
