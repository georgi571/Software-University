package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPer1Km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelPer1Km, int distanceTraveled) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPer1Km = fuelPer1Km;
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPer1Km() {
        return fuelPer1Km;
    }

    public void setFuelPer1Km(double fuelPer1Km) {
        this.fuelPer1Km = fuelPer1Km;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public boolean isFuelEnough(int distance) {
        return this.fuelAmount >= neededFuel(distance);
    }

    private double neededFuel(int distance) {
        return this.fuelPer1Km * distance;
    }

    public void reduceFuel(int distance) {
        this.fuelAmount -= neededFuel(distance);
    }

    public void increaseKM(int distance) {
        this.distanceTraveled += distance;
    }
}
