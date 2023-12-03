package _2ProgrammingFundamentalsWithJavaSeptember2023._4FinalExam._2OtherExam;

import com.sun.source.tree.IfTree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class _03WildZoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> hungryAnimals = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("EndDay")) {
            String[] commandParts = command.split(":\\s+");
            String currentCommand = commandParts[0];
            String[] animalInfo = commandParts[1].split("-");
            if (currentCommand.equals("Add")) {
                String animalName = animalInfo[0];
                int neededFood = Integer.parseInt(animalInfo[1]);
                String area = animalInfo[2];
                if (hungryAnimals.containsKey(animalName)) {
                    hungryAnimals.entrySet().forEach(entry -> {
                        if (entry.getKey().equals(animalName)) {
                            entry.getValue().entrySet().forEach(entry2 -> {
                                int getFood = entry2.getValue();
                                int newFood = getFood + neededFood;
                                Map<String, Integer> animal = new LinkedHashMap<>();
                                animal.put(area, newFood);
                                hungryAnimals.put(animalName, animal);
                            });
                        }
                    });
                } else {
                    if (hungryAnimals.containsKey(area)) {
                        hungryAnimals.get(animalName).put(area, neededFood);
                    } else {
                        Map<String, Integer> animal = new LinkedHashMap<>();
                        animal.put(area, neededFood);
                        hungryAnimals.put(animalName, animal);
                    }
                }
            } else if (currentCommand.equals("Feed")) {
                String animalName = animalInfo[0];
                int eatenFood = Integer.parseInt(animalInfo[1]);
                AtomicBoolean isFeed = new AtomicBoolean(false);
                if (hungryAnimals.containsKey(animalName)) {
                    hungryAnimals.entrySet().forEach(entry -> {
                        if (entry.getKey().equals(animalName)) {
                            entry.getValue().entrySet().forEach(entry2 -> {
                                int getFood = entry2.getValue();
                                int newFood = getFood - eatenFood;
                                Map<String, Integer> animal = new LinkedHashMap<>();
                                animal.put(entry2.getKey(), newFood);
                                hungryAnimals.put(animalName, animal);
                                if (newFood <= 0) {
                                    isFeed.set(true);
                                }
                            });
                        }
                    });
                }
                if (isFeed.get()) {
                    hungryAnimals.remove(animalName);
                    System.out.printf("%s was successfully fed%n",animalName);
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Animals:%n");
        Map<String , Integer> areaCounter = new LinkedHashMap<>();
        hungryAnimals.entrySet().forEach(entry -> {
            entry.getValue().entrySet().forEach( entry2-> {
                System.out.printf(" %s -> %dg%n",entry.getKey(), entry2.getValue());
                if (areaCounter.containsKey(entry2.getKey())) {
                    int getCounter = areaCounter.get(entry2.getKey());
                    int newCounter = getCounter + 1;
                    areaCounter.put(entry2.getKey(), newCounter);
                } else {
                    areaCounter.put(entry2.getKey(), 1);
                }
            });
        });
        System.out.printf("Areas with hungry animals:%n");
        areaCounter.entrySet().forEach(entry -> {
            System.out.printf(" %s: %d%n", entry.getKey(), entry.getValue());
        });
    }
}
