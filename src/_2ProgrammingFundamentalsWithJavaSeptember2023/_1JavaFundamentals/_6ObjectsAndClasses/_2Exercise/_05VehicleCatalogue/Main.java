package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._2Exercise._05VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Catalog> vehicleList = new ArrayList<>();
        int counterCar = 0;
        int counterTruck = 0;
        int carHorsepower = 0;
        int truckHorsepower = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] input = command.split(" ");
            String typeOfVehicle = input[0];
            String model = input[1];
            String color = input[2];
            int horsepower = Integer.parseInt(input[3]);
            if (typeOfVehicle.equals("car")) {
                typeOfVehicle = "Car";
                counterCar++;
                carHorsepower += horsepower;
            } else if (typeOfVehicle.equals("truck")) {
                typeOfVehicle = "Truck";
                counterTruck++;
                truckHorsepower += horsepower;
            }
            Catalog catalog = new Catalog(typeOfVehicle,model,color,horsepower);
            vehicleList.add(catalog);
            command = scanner.nextLine();
        }
        String commandModels = scanner.nextLine();
        while (!commandModels.equals("Close the Catalogue")) {
            String inputModel = commandModels;
            for (Catalog catalog : vehicleList ) {
                 if (catalog.getModel().equals(inputModel)) {
                    System.out.printf("Type: %s%n", catalog.getTypeOfVehicle());
                    System.out.printf("Model: %s%n", catalog.getModel());
                     System.out.printf("Color: %s%n", catalog.getColor());
                     System.out.printf("Horsepower: %d%n", catalog.getHorsepower());
                }
            }
            commandModels = scanner.nextLine();
        }
        double averageCarHorsepower = 1.0 * carHorsepower / counterCar;
        if (counterCar == 0) {
            averageCarHorsepower = 0.0;
        }
        double averageTruckHorsepower = 1.0 * truckHorsepower / counterTruck;
        if (counterTruck == 0) {
            averageTruckHorsepower = 0.0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n",averageCarHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.%n",averageTruckHorsepower);
    }
}
