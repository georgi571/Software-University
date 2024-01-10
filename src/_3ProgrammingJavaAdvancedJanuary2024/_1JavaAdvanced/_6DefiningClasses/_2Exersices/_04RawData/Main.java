package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] cars = scanner.nextLine().split(" ");
            String model = cars[0];
            int engineSpeed = Integer.parseInt(cars[1]);
            int enginePower = Integer.parseInt(cars[2]);
            int cargoWeight = Integer.parseInt(cars[3]);
            String cargoType = cars[4];
            double tire1Pressure = Double.parseDouble(cars[5]);
            int tire1Age = Integer.parseInt(cars[6]);
            double tire2Pressure = Double.parseDouble(cars[7]);
            int tire2Age = Integer.parseInt(cars[8]);
            double tire3Pressure = Double.parseDouble(cars[9]);
            int tire3Age = Integer.parseInt(cars[10]);
            double tire4Pressure = Double.parseDouble(cars[11]);
            int tire4Age = Integer.parseInt(cars[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tire);
            carsList.add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            for (int i = 0; i < carsList.size(); i++) {
                if (carsList.get(i).getCargo().getCargoType().equals("fragile")) {
                    if (carsList.get(i).getTire().getTire1Pressure() < 1 || carsList.get(i).getTire().getTire2Pressure() < 1 ||
                            carsList.get(i).getTire().getTire3Pressure() < 1 || carsList.get(i).getTire().getTire4Pressure() < 1) {
                        System.out.printf("%s%n", carsList.get(i).getModel());
                    }
                }
            }
        } else if (command.equals("flamable")) {
            for (int i = 0; i < carsList.size(); i++) {
                if (carsList.get(i).getCargo().getCargoType().equals("flamable")) {
                    if (carsList.get(i).getEngine().getEnginePower() > 250) {
                        System.out.printf("%s%n", carsList.get(i).getModel());
                    }
                }
            }
        }
    }
}
