package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.core.interfaces.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.cars.Car;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.cars.MuscleCar;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.cars.SportsCar;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.drivers.Driver;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.drivers.DriverImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.racers.Race;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.racers.RaceImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.CarRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.DriverRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.RaceRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.interfaces.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.common.ExceptionMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Car> carRepository;
    private Repository<Driver> driverRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> riderRepository, Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.carRepository = motorcycleRepository;
        this.driverRepository = riderRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driverToCreate = this.driverRepository.getByName(driver);
        if (driverToCreate != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        driverToCreate = new DriverImpl(driver);
        this.driverRepository.add(driverToCreate);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = this.carRepository.getByName(model);
        if (car != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }
        this.carRepository.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        Car car = this.carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        driver.addCar(car);
        return String.format(CAR_ADDED,driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        List<Driver> drivers = race.getDrivers().stream().sorted(Comparator.comparing(driver -> driver.getCar().calculateRacePoints(race.getLaps()))).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        result.append(String.format(DRIVER_FIRST_POSITION, drivers.get(drivers.size() - 1).getName(), race.getName())).append(System.lineSeparator());
        result.append(String.format(DRIVER_SECOND_POSITION, drivers.get(drivers.size() - 2).getName(), race.getName())).append(System.lineSeparator());
        result.append(String.format(DRIVER_THIRD_POSITION, drivers.get(drivers.size() - 3).getName(), race.getName())).append(System.lineSeparator());
        return result.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = this.raceRepository.getByName(name);
        if (race != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        race = new RaceImpl(name, laps);
        this.raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
