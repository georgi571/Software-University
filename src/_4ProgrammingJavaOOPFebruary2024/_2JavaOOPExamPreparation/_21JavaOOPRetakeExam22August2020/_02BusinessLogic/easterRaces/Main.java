package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.core.ControllerImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.core.EngineImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.core.interfaces.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.cars.Car;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.drivers.Driver;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.racers.Race;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.io.ConsoleReader;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.io.ConsoleWriter;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.CarRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.DriverRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.RaceRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.repositories.interfaces.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository<Car> motorcycleRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> riderRepository = new DriverRepository();

        Controller controller = new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
