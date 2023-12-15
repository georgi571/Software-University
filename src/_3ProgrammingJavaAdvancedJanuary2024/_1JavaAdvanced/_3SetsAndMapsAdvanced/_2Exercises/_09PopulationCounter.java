package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countrySize = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("report")) {
            String[] commandParts = command.split("\\|");
            String country = commandParts[1];
            String city = commandParts[0];
            long population = Long.parseLong(commandParts[2]);
            if (countries.containsKey(country)) {
                countries.get(country).put(city, population);
                countrySize.put(country, countrySize.get(country) + population);
            } else {
                LinkedHashMap<String, Long> cities = new LinkedHashMap<>();
                cities.put(city, population);
                countries.put(country, cities);
                countrySize.put(country, population);
            }
            command = scanner.nextLine();
        }
        countries.entrySet().stream()
            .sorted((c1, c2) -> countrySize.get(c2.getKey()).compareTo(countrySize.get(c1.getKey())))
            .forEach(entry -> {
                System.out.printf("%s (total population: %d)%n", entry.getKey(), countrySize.get(entry.getKey()));
                countrySize.get(entry.getKey());
                entry.getValue().entrySet().stream()
                    .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                    .forEach(entry2 -> {
                        System.out.printf("=>%s: %d%n", entry2.getKey(), entry2.getValue());
                    });
            });
    }
}
