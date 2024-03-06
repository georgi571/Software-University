package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climber.Climber;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climber.RockClimber;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climber.WallClimber;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climbing.Climbing;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climbing.ClimbingImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.mountain.Mountain;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.mountain.MountainImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.repositories.ClimberRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.repositories.MountainRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.repositories.Repository;

import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private final Repository<Climber> climberRepository;
    private final Repository<Mountain> mountainRepository;
    private int mountainsCount;

    public ControllerImpl() {
        this.climberRepository = new ClimberRepository();
        this.mountainRepository = new MountainRepository();
        this.mountainsCount = 0;
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        if (type.equals("RockClimber")) {
            climber = new RockClimber(climberName);
        } else if (type.equals("WallClimber")) {
            climber = new WallClimber(climberName);
        } else {
            throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        }
        this.climberRepository.add(climber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }
        this.mountainRepository.add(mountain);
        return String.format(MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = this.climberRepository.byName(climberName);
        if (climber == null) {
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }
        this.climberRepository.remove(climber);
        return String.format(CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Collection<Climber> climbers = this.climberRepository.getCollection();
        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }
        Mountain mountain = this.mountainRepository.byName(mountainName);
        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climbers);
        int removedClimbers = 0;
        for (Climber climber : climbers) {
            if (climber.getStrength() == 0) {
                removedClimbers++;
            }
        }
        this.mountainsCount++;
        return String.format(PEAK_CLIMBING, mountainName, removedClimbers);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format(FINAL_MOUNTAIN_COUNT, this.mountainsCount)).append(System.lineSeparator());
        statistics.append(String.format(FINAL_CLIMBERS_STATISTICS)).append(System.lineSeparator());
        for (Climber climber : this.climberRepository.getCollection()) {
            statistics.append(String.format(FINAL_CLIMBER_NAME, climber.getName())).append(System.lineSeparator());
            statistics.append(String.format(FINAL_CLIMBER_STRENGTH, climber.getStrength())).append(System.lineSeparator());
            if (climber.getRoster().getPeaks().isEmpty()) {
                statistics.append(String.format(FINAL_CLIMBER_PEAKS, "None")).append(System.lineSeparator());
            } else {
                statistics.append(String.format(FINAL_CLIMBER_PEAKS, String.join(FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks()))).append(System.lineSeparator());
            }
        }
        return statistics.toString().trim();
    }
}
