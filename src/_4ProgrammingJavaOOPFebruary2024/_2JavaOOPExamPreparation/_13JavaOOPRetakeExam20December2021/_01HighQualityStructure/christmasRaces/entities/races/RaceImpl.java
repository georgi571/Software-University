package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.entities.races;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.entities.drivers.Driver;

import java.util.Collection;
import java.util.Collections;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.common.ExceptionMessages.INVALID_NAME;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021._01HighQualityStructure.christmasRaces.common.ExceptionMessages.INVALID_NUMBER_OF_LAPS;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }
        this.laps = laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void addDriver(Driver driver) {

    }
}
