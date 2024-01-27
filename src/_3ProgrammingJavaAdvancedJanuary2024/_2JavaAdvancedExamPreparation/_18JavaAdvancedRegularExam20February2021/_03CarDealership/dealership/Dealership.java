package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._18JavaAdvancedRegularExam20February2021._03CarDealership.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car datum : this.data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        for (Car datum : this.data) {
            if (latestCar == null) {
                latestCar = datum;
            } else {
                if (datum.getYear() > latestCar.getYear()) {
                    latestCar = datum;
                }
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car datum : this.data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                return datum;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The cars are in a car dealership %s:%n",this.name)).trimToSize();
        for (Car datum : this.data) {
            stringBuilder.append(String.format("%s%n", datum.toString()));
        }
        return stringBuilder.toString().trim();
    }

}
