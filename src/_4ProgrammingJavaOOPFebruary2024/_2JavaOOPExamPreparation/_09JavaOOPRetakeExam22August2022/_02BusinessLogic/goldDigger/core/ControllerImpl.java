package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.discoverer.Anthropologist;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.discoverer.Archaeologist;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.discoverer.Discoverer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.discoverer.Geologist;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.operation.Operation;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.operation.OperationImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.spot.Spot;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.models.spot.SpotImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.repositories.DiscovererRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.repositories.Repository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._02BusinessLogic.goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;
    int inspectedSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.inspectedSpots = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = null;
        if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);
        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discovererRepository.remove(discoverer);
        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Collection<Discoverer> discovererList = discovererRepository.getCollection().stream().filter(discoverer -> discoverer.getEnergy() > 45).collect(Collectors.toList());
        if (discovererList.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        operation.startOperation(spotRepository.byName(spotName),discovererList);
        inspectedSpots++;
        long discoverersWithoutEnergy = discovererList.stream().filter(discoverer -> discoverer.getEnergy() == 0).count();
        return String.format(INSPECT_SPOT, spotName, discoverersWithoutEnergy);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(FINAL_SPOT_INSPECT, inspectedSpots)).append(System.lineSeparator());
        stringBuilder.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        for (Discoverer discoverer : discovererRepository.getCollection()) {
            stringBuilder.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName())).append(System.lineSeparator());
            stringBuilder.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy())).append(System.lineSeparator());
            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                stringBuilder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                stringBuilder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits()))).append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }
}
