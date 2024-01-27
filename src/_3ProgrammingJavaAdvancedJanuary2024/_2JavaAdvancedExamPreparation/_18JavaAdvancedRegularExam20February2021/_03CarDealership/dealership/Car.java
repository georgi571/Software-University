package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._18JavaAdvancedRegularExam20February2021._03CarDealership.dealership;

public class Car {
    public String manufacturer;
    public String model;
    public int year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", getManufacturer(), getModel(), getYear());
    }
}
