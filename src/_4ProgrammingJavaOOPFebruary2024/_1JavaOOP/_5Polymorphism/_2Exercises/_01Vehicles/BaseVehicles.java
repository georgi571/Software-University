package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._2Exercises._01Vehicles;

import java.text.DecimalFormat;

public abstract class BaseVehicles implements Vehicles{
    private Double fuelQuantity;
    private Double fuelConsumption ;

    public BaseVehicles(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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
        this.fuelQuantity += litters;
    }
}
