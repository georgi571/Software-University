package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._5Polymorphism._2Exercises._01Vehicles;

public class Car extends BaseVehicles {
    private final static double ADDITIONAL_AC_CONSUMPTION = 0.9;
    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(super.getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION);
    }
}
