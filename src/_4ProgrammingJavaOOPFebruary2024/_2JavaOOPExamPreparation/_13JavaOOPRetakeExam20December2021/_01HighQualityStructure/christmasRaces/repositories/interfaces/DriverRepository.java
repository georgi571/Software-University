package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.repositories.interfaces;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.entities.drivers.Driver;

import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {
    private Collection<Driver> drivers;
    @Override
    public Driver getByName(String name) {
        for (Driver driver : this.drivers) {
            if (driver.getName().equals(name)) {
                return driver;
            }
        }
        return null;
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void add(Driver driver) {
        this.drivers.add(driver);
    }

    @Override
    public boolean remove(Driver driver) {
        if (this.drivers.contains(driver)) {
            this.drivers.remove(driver);
            return true;
        }
        return false;
    }
}
