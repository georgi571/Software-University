package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._1Lab._02Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.%n",getBrand(), getModel(), getHorsepower());
    }
}
