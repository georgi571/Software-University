package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._2Exercises._02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class BaseVehicles implements Vehicles {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double tankCapacity;

    public BaseVehicles(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive (Double distance) {
        double fuelNeeded = this.fuelConsumption * distance;
        if (fuelNeeded > this.fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        this.fuelQuantity -= fuelNeeded;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
    }

    @Override
    public void refuel(Double litters) {
        if (litters > 0) {
            if (litters <= this.tankCapacity - this.fuelQuantity) {
                this.fuelQuantity += litters;
            } else {
                System.out.printf("Cannot fit fuel in tank%n");
            }
        } else {
            System.out.printf("Fuel must be a positive number%n");
        }
    }
}
