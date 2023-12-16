package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> concerts = getConcerts(scanner);
        printOutput(concerts);
    }
    private static Map<String, Map<String, Integer>> getConcerts(Scanner scanner) {
        Map<String, Map<String, Integer>> concerts = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(?<singer>[\\w+\\s*\\w+]+)\\s@(?<venue>[\\w+\\s*\\w+]+)\\s(?<ticketsPrice>\\d+)\\s(?<ticketsCount>\\d+)");
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            Matcher matcher = pattern.matcher(command);
            while (matcher.find()) {
                String venue = matcher.group("venue");
                String singer = matcher.group("singer");
                int moneyFromConcert = Integer.parseInt(matcher.group("ticketsPrice")) * Integer.parseInt(matcher.group("ticketsCount"));
                if (concerts.containsKey(venue)) {
                    if (concerts.get(venue).containsKey(singer)) {
                        concerts.get(venue).put(singer, concerts.get(venue).get(singer) + moneyFromConcert);
                    } else {
                        concerts.get(venue).put(singer, moneyFromConcert);
                    }
                } else {
                    Map<String, Integer> singers = new LinkedHashMap<>();
                    singers.put(singer, moneyFromConcert);
                    concerts.put(venue, singers);
                }
            }
            command = scanner.nextLine();
        }
        return concerts;
    }
    private static void printOutput(Map<String, Map<String, Integer>> concerts) {
        concerts.entrySet().forEach(entry -> {
            System.out.printf("%s%n", entry.getKey());
            entry.getValue().entrySet().stream().sorted((s1, s2) -> entry.getValue().get(s2.getKey()).compareTo(entry.getValue().get(s1.getKey())))
                    .forEach(entry2 -> {
                System.out.printf("#  %s -> %d%n", entry2.getKey(), entry2.getValue());
            });
        });
    }
}
