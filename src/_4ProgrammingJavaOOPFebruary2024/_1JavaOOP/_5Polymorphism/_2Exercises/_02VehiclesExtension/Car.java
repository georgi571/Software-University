package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._2Exercises._02VehiclesExtension;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._2Exercises._02VehiclesExtension.BaseVehicles;

public class Car extends BaseVehicles {
    private final static double ADDITIONAL_AC_CONSUMPTION = 0.9;
    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(super.getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION);
    }
}
