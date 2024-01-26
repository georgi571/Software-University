package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._03JavaAdvancedRegularExam17June2023._03AutomotiveRepairShop.automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop (int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                return this.vehicles.remove(vehicle);
            }
        }
        return false;
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        Vehicle lowestMileage = null;
        for (Vehicle vehicle : this.vehicles) {
            if (lowestMileage == null) {
                lowestMileage = vehicle;
            }
            if (vehicle.getMileage() < lowestMileage.getMileage()) {
                lowestMileage = vehicle;
            }
        }
        return lowestMileage;
    }
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vehicles in the preparatory:\n");
        for (Vehicle vehicle : this.vehicles) {
            stringBuilder.append(vehicle.toString() + "\n");
        }

        return stringBuilder.toString();
    }
}
