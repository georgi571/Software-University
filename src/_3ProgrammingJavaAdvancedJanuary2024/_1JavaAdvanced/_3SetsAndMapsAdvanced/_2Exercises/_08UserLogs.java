package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class _08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> usersInfo = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandParts = command.split("\\s+");
            String ip = commandParts[0].substring(3);
            String user = commandParts[2].substring(5);
            if (usersInfo.containsKey(user)) {
                if (usersInfo.get(user).containsKey(ip)) {
                    usersInfo.get(user).put(ip, usersInfo.get(user).get(ip) + 1 );
                } else {
                    usersInfo.get(user).put(ip, 1);
                }
            } else {
                LinkedHashMap<String, Integer> ipAddress = new LinkedHashMap<>();
                ipAddress.put(ip, 1);
                usersInfo.put(user, ipAddress);
            }
            command = scanner.nextLine();
        }
        usersInfo.entrySet().forEach(entry -> {
            System.out.printf("%s:%n", entry.getKey());
            AtomicInteger counter = new AtomicInteger(entry.getValue().size() - 1);
            entry.getValue().entrySet().forEach(entry2 -> {
                if (counter.get() > 0) {
                    System.out.printf("%s => %s, ", entry2.getKey(), entry2.getValue());
                    counter.getAndDecrement();
                } else {
                    System.out.printf("%s => %s.%n", entry2.getKey(), entry2.getValue());
                }
            });
        });
    }
}
