package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.robot.FemaleRobot;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.robot.MaleRobot;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.robot.Robot;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.services.MainService;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.services.SecondaryService;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.services.Service;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.supplements.MetalArmor;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.supplements.PlasticArmor;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.entities.supplements.Supplement;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.repositories.Repository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._02BusinessLogic.robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        if (type.equals("MainService")) {
            service = new MainService(name);
        } else if (type.equals("SecondaryService")) {
            service = new SecondaryService(name);
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        this.services.add(service);
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        if (type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
        } else if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplements.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        for (Service service : this.services) {
            if (service.getName().equals(serviceName)) {
                service.addSupplement(supplement);
                this.supplements.removeSupplement(supplement);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName, robotKind, price);
            for (Service service : this.services) {
                if (service.getClass().getSimpleName().equals("MainService")) {
                    if (service.getName().equals(serviceName)) {
                        service.addRobot(robot);
                        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
                    }
                }
            }
        } else if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName, robotKind, price);
            for (Service service : this.services) {
                if (service.getClass().getSimpleName().equals("SecondaryService")) {
                    if (service.getName().equals(serviceName)) {
                        service.addRobot(robot);
                        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        return String.format(UNSUITABLE_SERVICE);
    }

    @Override
    public String feedingRobot(String serviceName) {
        int count = 0;
        for (Service service : this.services) {
            if (service.getName().equals(serviceName)) {
                for (Robot robot : service.getRobots()) {
                    robot.eating();
                    count++;
                }
            }
        }
        return String.format(FEEDING_ROBOT, count);
    }

    @Override
    public String sumOfAll(String serviceName) {
        double sum = 0;
        for (Service service : this.services) {
            if (service.getName().equals(serviceName)) {
                for (Robot robot : service.getRobots()) {
                    sum += robot.getPrice();
                }
                for (Supplement supplement : service.getSupplements()) {
                    sum += supplement.getPrice();
                }
            }
        }
        return String.format(VALUE_SERVICE, serviceName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (Service service : this.services) {
            statistics.append(String.format("%s", service.getStatistics()));
        }
        return statistics.toString().trim();
    }
}
