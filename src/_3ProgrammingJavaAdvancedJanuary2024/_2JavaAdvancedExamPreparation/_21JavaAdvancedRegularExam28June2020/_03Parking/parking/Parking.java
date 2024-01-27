package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._21JavaAdvancedRegularExam28June2020._03Parking.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car datum : this.data) {
            if (datum.getManufacturer().equals(manufacturer) && datum.getModel().equals(model)) {
                return this.data.remove(datum);
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;
        for (Car datum : this.data) {
            if (car == null) {
                car = datum;
            } else {
                if (datum.getYear() > car.getYear()) {
                    car = datum;
                }
            }
        }
        return car;
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
        stringBuilder.append(String.format("The cars are parked in %s:%n", this.type)).trimToSize();
        for (Car datum : this.data) {
            stringBuilder.append(String.format("%s%n", datum.toString()));
        }
        return stringBuilder.toString().trim();
    }

}
