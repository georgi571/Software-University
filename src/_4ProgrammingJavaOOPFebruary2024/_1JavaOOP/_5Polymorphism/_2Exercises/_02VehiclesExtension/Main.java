package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._2Exercises._02VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInput = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]), Double.parseDouble(carInput[3]));
        String[] truckInput = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]), Double.parseDouble(truckInput[3]));
        String[] busInput = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInput[1]), Double.parseDouble(busInput[2]), Double.parseDouble(busInput[3]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            if (command.equals("Drive")) {
                if (commandParts[1].equals("Car")) {
                    System.out.printf("%s%n", car.drive(Double.parseDouble(commandParts[2])));
                } else if (commandParts[1].equals("Truck")) {
                    System.out.printf("%s%n", truck.drive(Double.parseDouble(commandParts[2])));
                } else {
                    System.out.printf("%s%n", bus.drive(Double.parseDouble(commandParts[2])));
                }
            } else if (command.equals("Refuel")) {
                if (commandParts[1].equals("Car")) {
                    car.refuel(Double.parseDouble(commandParts[2]));
                } else if (commandParts[1].equals("Truck")) {
                    truck.refuel(Double.parseDouble(commandParts[2]));
                } else {
                    bus.refuel(Double.parseDouble(commandParts[2]));
                }
            } else if (command.equals("DriveEmpty")) {
                System.out.printf("%s%n", bus.driveEmpty(Double.parseDouble(commandParts[2])));
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }
}
