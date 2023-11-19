package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._2ProgrammingFundamentalsFinalExam;

import java.util.*;

public class _03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<Integer, List<Double>>> plants = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plantName = input[0];
            int rarity = Integer.parseInt(input[1]);
            List<Double> rating = new ArrayList<>();
            Map<Integer, List<Double>> plantRarity = new LinkedHashMap<>();
            plantRarity.put(rarity, rating);
            plants.put(plantName, plantRarity);
        }
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            String[] commandParts = command.split("\\s*:\\s*");
            String currentCommand = commandParts[0];
            String[] currentCommandParts = commandParts[1].split("\\s*-\\s*");
            if (plants.containsKey(currentCommandParts[0])) {
                if (currentCommand.equals("Rate")) {
                    String plantName = currentCommandParts[0];
                    double rating = Double.parseDouble(currentCommandParts[1]);
                    if (plants.containsKey(plantName)) {
                        plants.entrySet().forEach(entry -> {
                            if (entry.getKey().equals(plantName)) {
                                entry.getValue().entrySet().forEach(entry2 -> {
                                    int plantRarity = Integer.parseInt(String.valueOf(entry2.getKey()));
                                    entry2.getValue().add(rating);
                                });
                            }
                        });
                    }
                } else if (currentCommand.equals("Update")) {
                    String plantName = currentCommandParts[0];
                    int newRarity = Integer.parseInt(currentCommandParts[1]);
                    if (plants.containsKey(plantName)) {
                        plants.entrySet().forEach(entry -> {
                            if (entry.getKey().equals(plantName)) {
                                entry.getValue().entrySet().forEach(entry2 -> {
                                    int oldRarity = entry2.getKey();
                                    List<Double> oldInformation = entry2.getValue();
                                    Map<Integer, List<Double>> oldMap = new LinkedHashMap<>();
                                    oldMap.put(oldRarity, oldInformation);
                                    Map<Integer, List<Double>> newMap = new LinkedHashMap<>();
                                    newMap.put(newRarity, oldInformation);
                                    plants.replace(plantName, oldMap, newMap);
                                });
                            }
                        });
                    }
                } else if (currentCommand.equals("Reset")) {
                    String plantName = currentCommandParts[0];
                    if (plants.containsKey(plantName)) {
                        plants.entrySet().forEach(entry -> {
                            if (entry.getKey().equals(plantName)) {
                                entry.getValue().entrySet().forEach(entry2 -> {
                                    int rarity = entry2.getKey();
                                    entry2.getValue().clear();
                                });
                            }
                        });
                    }
                }
            } else {
                System.out.printf("error%n");
            }
            command = scanner.nextLine();
        }
        System.out.printf("Plants for the exhibition:%n");
        plants.entrySet().forEach(entry -> {
            entry.getValue().entrySet().forEach(entry2 -> {
                double totalRating = 0;
                int numberOfRatings = 0;
                for (int i = 0; i < entry2.getValue().size(); i++) {
                    totalRating += entry2.getValue().get(i);
                    numberOfRatings++;
                }
                double avarageRatint =  totalRating / numberOfRatings;
                if (numberOfRatings > 0) {
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry2.getKey(), avarageRatint);
                } else {
                    System.out.printf("- %s; Rarity: %d; Rating: 0.00%n", entry.getKey(), entry2.getKey());
                }
            });
        });
    }
}
