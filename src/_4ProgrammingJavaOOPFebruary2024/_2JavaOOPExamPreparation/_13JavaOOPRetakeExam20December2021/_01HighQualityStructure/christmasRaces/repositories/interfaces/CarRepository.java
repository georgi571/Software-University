package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.repositories.interfaces;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.entities.cars.Car;

import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {
    private Collection<Car> cars;
    @Override
    public Car getByName(String name) {
        for (Car car : this.cars) {
            if (car.getModel().equals(name)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(cars);
    }

    @Override
    public void add(Car car) {
        this.cars.add(car);
    }

    @Override
    public boolean remove(Car car) {
        if (this.cars.contains(car)) {
            remove(car);
            return true;
        }
        return false;
    }
}
