package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.core;

public interface Controller {
    String addWorker(String type, String workerName);

    String addVehicle(String vehicleName, int strengthRequired);

    String addToolToWorker(String workerName, int power);

    String makingVehicle(String vehicleName);

    String statistics();
}
