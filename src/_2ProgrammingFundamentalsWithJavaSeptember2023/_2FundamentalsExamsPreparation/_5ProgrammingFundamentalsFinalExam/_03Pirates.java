package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._5ProgrammingFundamentalsFinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class _03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<Integer, Integer>> cities = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String[] inputPart = input.split("\\|\\|");
            String city = inputPart[0];
            int population = Integer.parseInt(inputPart[1]);
            int gold = Integer.parseInt(inputPart[2]);
            if (cities.containsKey(city)){
                cities.entrySet().forEach(entry -> {
                    if (entry.getKey().equals(city)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getPopulation = entry2.getKey();
                            int getGold = entry2.getValue();
                            int newPopulation = getPopulation + population;
                            int newGold = getGold + gold;
                            Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                            oldInfo.put(getPopulation, getGold);
                            Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                            newInfo.put(newPopulation, newGold);
                            cities.replace(city, oldInfo, newInfo);
                        });
                    }
                });
            } else {
                Map<Integer, Integer> cityInfo = new LinkedHashMap<>();
                cityInfo.put(population, gold);
                cities.put(city, cityInfo);
            }
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("=>");
            String currentCommand = commandParts[0];
            String town = commandParts[1];
            if (currentCommand.equals("Plunder")) {
                int people = Integer.parseInt(commandParts[2]);
                int gold = Integer.parseInt(commandParts[3]);
                AtomicInteger populationAfterPlunder = new AtomicInteger();
                AtomicInteger goldAfterPlunder = new AtomicInteger();
                cities.entrySet().forEach(entry -> {
                    if (entry.getKey().equals(town)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getPopulation = entry2.getKey();
                            int getGold = entry2.getValue();
                            int newPopulation = getPopulation - people;
                            int newGold = getGold - gold;
                            populationAfterPlunder.set(newPopulation);
                            goldAfterPlunder.set(newGold);
                            Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                            oldInfo.put(getPopulation, getGold);
                            Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                            newInfo.put(newPopulation, newGold);
                            cities.replace(town, oldInfo, newInfo);
                            System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                        });
                    }
                });
                if (populationAfterPlunder.get() <= 0 || goldAfterPlunder.get() <= 0) {
                    cities.remove(town);
                    System.out.printf("%s has been wiped off the map!%n", town);
                }
            } else if (currentCommand.equals("Prosper")) {
                int gold = Integer.parseInt(commandParts[2]);
                if (gold > 0) {
                    cities.entrySet().forEach(entry -> {
                        if (entry.getKey().equals(town)) {
                            entry.getValue().entrySet().forEach(entry2 -> {
                                int getPopulation = entry2.getKey();
                                int getGold = entry2.getValue();
                                int newGold = getGold + gold;
                                Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                                oldInfo.put(getPopulation, getGold);
                                Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                                newInfo.put(getPopulation, newGold);
                                cities.replace(town, oldInfo, newInfo);
                                System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, newGold);
                            });
                        }
                    });
                } else {
                    System.out.printf("Gold added cannot be a negative number!%n");
                }
            }
            command = scanner.nextLine();
        }
        AtomicInteger counter = new AtomicInteger();
        counter.set(0);
        cities.entrySet().forEach(entry -> {
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        counter.getAndIncrement();
                    }
                });
        if (counter.get() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", counter.get());
            cities.entrySet().forEach(entry -> {
                entry.getValue().entrySet().forEach(entry2 -> {
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry2.getKey(), entry2.getValue());
                });
            });
        } else {
            System.out.printf("Ahoy, Captain! All targets have been plundered and destroyed!%n");
        }
    }
}
