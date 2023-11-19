package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._3ProgrammingFundamentalsFinalExamRetake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class _03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<Integer, Integer>> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String carName = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            Map<Integer, Integer> carInfo = new LinkedHashMap<>();
            carInfo.put(mileage, fuel);
            cars.put(carName, carInfo);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandParts = command.split(" : ");
            if (commandParts[0].equals("Drive")) {
                String car = commandParts[1];
                int distance = Integer.parseInt(commandParts[2]);
                int neededFuel = Integer.parseInt(commandParts[3]);
                AtomicInteger finalMileage = new AtomicInteger();
                cars.entrySet().forEach(entry -> {
                    if (entry.getKey().equals(car)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getMileage = entry2.getKey();
                            int getFuel = entry2.getValue();
                            if (getFuel < neededFuel) {
                                System.out.printf("Not enough fuel to make that ride%n");
                            } else {
                                int newMileage = getMileage + distance;
                                int newFuel = getFuel - neededFuel;
                                finalMileage.set(newMileage);
                                Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                                oldInfo.put(getMileage, getFuel);
                                Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                                newInfo.put(newMileage, newFuel);
                                cars.replace(car, oldInfo, newInfo);
                                System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",car, distance, neededFuel);
                            }
                        });
                    }
                });
                if (finalMileage.get() > 100000) {
                    cars.remove(car);
                    System.out.printf("Time to sell the %s!%n", car);
                }
            } else if (commandParts[0].equals("Refuel")) {
                String car = commandParts[1];
                int fuel = Integer.parseInt(commandParts[2]);
                cars.entrySet().forEach(entry -> {
                    if (entry.getKey().equals(car)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getMileage = entry2.getKey();
                            int getFuel = entry2.getValue();
                            int newFuel = getFuel + fuel;
                            if (newFuel > 75) {
                                newFuel = 75;
                            }
                            int refuel = newFuel - getFuel;
                            cars.get(car).put(getMileage, newFuel);
                            System.out.printf("%s refueled with %d liters%n", car , refuel);
                        });
                    }
                });
            } else if (commandParts[0].equals("Revert")) {
                String car = commandParts[1];
                int kilometers = Integer.parseInt(commandParts[2]);
                cars.entrySet().forEach(entry -> {
                    if (entry.getKey().equals(car)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getMileage = entry2.getKey();
                            int getFuel = entry2.getValue();
                            int newMileage = getMileage - kilometers;
                            if (newMileage < 10000) {
                                newMileage = 10000;
                            } else {
                                System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                            }
                            Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                            oldInfo.put(getMileage, getFuel);
                            Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                            newInfo.put(newMileage, getFuel);
                            cars.replace(car, oldInfo, newInfo);
                        });
                    }
                });
            }
            command = scanner.nextLine();
        }
        cars.entrySet().forEach(entry -> {
            entry.getValue().entrySet().forEach( entry2 -> {
                System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry2.getKey(), entry2.getValue());
            });
        });
    }
}
