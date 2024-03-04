package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._01HighQualityStructure.easterRaces.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._01HighQualityStructure.easterRaces.entities.cars.Car;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._01HighQualityStructure.easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {
    private Collection<Car> cars;
    @Override
    public Car getByName(String name) {
        for (Car car : this.cars) {
            if (car.getClass().getSimpleName().equals(name)) {
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
        if (cars.contains(car)) {
            this.cars.remove(car);
            return true;
        }
        return false;
    }
}
