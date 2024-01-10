package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFor1km = Double.parseDouble(input[2]);
            int distanceTraveled = 0;
            Car car = new Car(model, fuelAmount, fuelCostFor1km, distanceTraveled);
            cars.put(model, car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("\\s+");
            String carModel = commandParts[1];
            int amountOfKm = Integer.parseInt(commandParts[2]);
            Car car = cars.get(carModel);
            if (car.isFuelEnough(amountOfKm)) {
                cars.get(carModel).reduceFuel(amountOfKm);
                cars.get(carModel).increaseKM(amountOfKm);
            } else {
                System.out.printf("Insufficient fuel for the drive%n");
            }
            command = scanner.nextLine();
        }
        cars.entrySet().forEach(entry -> {
            System.out.printf("%s %.2f %d%n", entry.getValue().getModel(),entry.getValue().getFuelAmount(),entry.getValue().getDistanceTraveled());
        });
    }
}
