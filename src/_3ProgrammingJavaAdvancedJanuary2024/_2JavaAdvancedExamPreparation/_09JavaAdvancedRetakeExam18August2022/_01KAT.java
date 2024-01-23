package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._09JavaAdvancedRetakeExam18August2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> license = new ArrayDeque<>();
        List<Integer> allLicense = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allLicense.size(); i++) {
            license.offer(allLicense.get(i));
        }
        Deque<Integer> cars = new ArrayDeque<>();
        List<Integer> allCars = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allCars.size(); i++) {
            cars.push(allCars.get(i));
        }
        long days = 0;
        long registredCars = 0;
        while (!license.isEmpty() && !cars.isEmpty()) {
            days++;
            int currentLicense = license.poll();
            int neededForCars = currentLicense / 2;
            int currentCars = cars.pop();
            if (neededForCars > currentCars) {
                registredCars += currentCars;
                currentLicense -= currentCars * 2;
                license.offer(currentLicense);
            } else if (neededForCars < currentCars) {
                currentCars -= neededForCars;
                registredCars += neededForCars;
                cars.addLast(currentCars);
            } else {
                registredCars += currentCars;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", registredCars, days);
        if (license.isEmpty() && cars.isEmpty()) {
            System.out.printf("Good job! There is no queue in front of the KAT!%n");
        } else {
            if (!license.isEmpty()) {
                long licenseCounter = 0;
                while (!license.isEmpty()) {
                    licenseCounter += license.poll();
                }
                System.out.printf("%d license plates remain!%n", licenseCounter);
            }
            if (!cars.isEmpty()) {
                long carsCounter = 0;
                while (!cars.isEmpty()) {
                    carsCounter += cars.pop();
                }
                System.out.printf("%d cars remain without license plates!%n", carsCounter);
            }
        }
    }
}
