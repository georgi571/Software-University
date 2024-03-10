package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.shop.Shop;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.shop.ShopImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.tool.Tool;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.tool.ToolImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.vehicle.Vehicle;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.vehicle.VehicleImpl;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.worker.FirstShift;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.worker.SecondShift;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.worker.Worker;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.repositories.Repository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.repositories.VehicleRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.repositories.WorkerRepository;

import java.util.ArrayList;
import java.util.List;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Worker> workerRepository;
    private Repository<Vehicle> vehicleRepository;
    private Shop shop;

    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;
        if (type.equals("FirstShift")) {
            worker = new FirstShift(workerName);
        } else if (type.equals("SecondShift")) {
            worker = new SecondShift(workerName);
        } else {
            throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }
        workerRepository.add(worker);
        return String.format(ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        vehicleRepository.add(vehicle);
        return String.format(SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Tool tool = new ToolImpl(power);
        for (Worker worker : workerRepository.getWorkers()) {
            if (worker.getName().equals(workerName)) {
                worker.addTool(tool);
                return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
            }
        }
        throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        int brokenTools = 0;
        Vehicle vehicle = this.vehicleRepository.findByName(vehicleName);
        List<Worker> workers = new ArrayList<>();
        for (Worker worker : this.workerRepository.getWorkers()) {
            if (worker.getStrength() > 70) {
                workers.add(worker);
            }
        }
        if (workers.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }
        for (Worker worker : workers) {
            shop.make(vehicle, worker);
            for (Tool tool : worker.getTools()) {
                if (tool.isUnfit()) {
                    brokenTools++;
                }
            }
            if (vehicle.reached()) {
                break;
            }
        }
        boolean isDone = vehicle.reached();
        String output = "";
        if (isDone) {
            output = "done";
        } else {
            output = "not done";
        }
        return String.format(VEHICLE_DONE, vehicleName, output) + String.format(COUNT_BROKEN_INSTRUMENTS, brokenTools);
    }

    @Override
    public String statistics() {
        StringBuilder statistics = new StringBuilder();
        int ready = 0;
        for (Vehicle vehicle : this.vehicleRepository.getWorkers()) {
            if (vehicle.reached()) {
                ready++;
            }
        }
        statistics.append(String.format("%d vehicles are ready!", ready)).append(System.lineSeparator());
        statistics.append(String.format("Info for workers:")).append(System.lineSeparator());
        for (Worker worker : this.workerRepository.getWorkers()) {
            int leftTools = 0;
            for (Tool tool : worker.getTools()) {
                if (!tool.isUnfit()) {
                    leftTools++;
                }
            }
            statistics.append(String.format("Name: %s, Strength: %d", worker.getName(), worker.getStrength())).append(System.lineSeparator());
            statistics.append(String.format("Tools: %d fit left", leftTools)).append(System.lineSeparator());
        }
        return statistics.toString().trim();
    }
}
