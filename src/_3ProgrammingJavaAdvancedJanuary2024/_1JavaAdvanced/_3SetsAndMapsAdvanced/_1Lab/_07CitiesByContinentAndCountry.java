package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._1Lab;

import java.util.*;

public class _07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] continentsInfo = scanner.nextLine().split("\\s+");
            String continent = continentsInfo[0];
            String country = continentsInfo[1];
            String city = continentsInfo[2];
            if (continents.containsKey(continent)) {
                if (continents.get(continent).containsKey(country)) {
                    continents.get(continent).get(country).add(city);
                } else {
                    List<String> cities = new ArrayList<>();
                    cities.add(city);
                    continents.get(continent).put(country, cities);
                }
            } else {
                Map<String, List<String>> countries = new LinkedHashMap<>();
                List<String> cities = new ArrayList<>();
                cities.add(city);
                countries.put(country, cities);
                continents.put(continent, countries);
            }
        }
        continents.entrySet().forEach(entry -> {
            System.out.printf("%s:%n", entry.getKey());
            entry.getValue().entrySet().forEach(entry2 -> {
                System.out.printf("  %s -> %s%n", entry2.getKey(), String.join(", ", entry2.getValue()));
            });
        });
    }
}
