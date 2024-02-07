package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._04NeedForSpeed;

public class SportCar extends Car {
    private static final double DEFAULT_FUEL_CONSUMPTION = 10;
    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
