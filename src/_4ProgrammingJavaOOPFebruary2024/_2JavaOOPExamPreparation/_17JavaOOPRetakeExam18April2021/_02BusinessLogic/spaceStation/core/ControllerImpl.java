package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts.Astronaut;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts.Biologist;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts.Geodesist;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts.Meteorologist;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.mission.Mission;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.mission.MissionImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.planets.Planet;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.planets.PlanetImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.repositories.AstronautRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.repositories.PlanetRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private int count;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.count = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        this.planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        this.astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = this.planetRepository.findByName(planetName);
        List<Astronaut> astronauts = this.astronautRepository.getModels().stream().filter(astronaut -> astronaut.getOxygen() > 60).collect(Collectors.toList());
        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(planet, astronauts);
        long deadAstronauts = astronauts.stream().filter(astronaut -> !astronaut.canBreath()).count();
        this.count++;
        return String.format(PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(String.format(REPORT_PLANET_EXPLORED, this.count)).append(System.lineSeparator());
        report.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            report.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName())).append(System.lineSeparator());
            report.append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen())).append(System.lineSeparator());
            if (astronaut.getBag().getItems().isEmpty()) {
                report.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
            } else {
                report.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems()))).append(System.lineSeparator());
            }
        }
        return report.toString().trim();
    }
}
