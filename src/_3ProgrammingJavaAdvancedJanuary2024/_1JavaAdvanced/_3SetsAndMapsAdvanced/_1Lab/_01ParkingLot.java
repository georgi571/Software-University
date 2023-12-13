package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._1Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split(", ");
            if (commandParts[0].equals("IN")) {
                parking.add(commandParts[1]);
            } else if (commandParts[0].equals("OUT")) {
                parking.remove(commandParts[1]);
            }
            command = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.printf("Parking Lot is Empty%n");
        } else {
            for (String car : parking) {
                System.out.printf("%s%n", car);
            }
        }
    }
}
