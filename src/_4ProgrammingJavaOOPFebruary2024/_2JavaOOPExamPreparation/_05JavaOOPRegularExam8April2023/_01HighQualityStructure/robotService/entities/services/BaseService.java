package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.services;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.robot.Robot;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.supplements.Supplement;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.common.ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseService implements Service {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return Collections.unmodifiableCollection(robots);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(supplements);
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.capacity >= robots.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : this.robots) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        int hardness = 0;
        for (Supplement supplement : this.supplements) {
            hardness += supplement.getHardness();
        }
        return hardness;
    }

    @Override
    public String getStatistics() {
        return String.format("%s %s%nRobots: %s%nSupplements: %d, Hardness: %d%n",
                this.name, this.getClass().getSimpleName(),
                this.robots.stream().map(Robot::getName).collect(Collectors.joining(" ")),
                this.supplements.size(), sumHardness());
    }
}
