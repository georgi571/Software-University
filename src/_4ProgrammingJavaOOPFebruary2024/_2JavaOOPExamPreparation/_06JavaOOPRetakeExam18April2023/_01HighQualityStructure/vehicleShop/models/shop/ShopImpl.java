package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._01HighQualityStructure.vehicleShop.models.shop;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._01HighQualityStructure.vehicleShop.models.tool.Tool;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._01HighQualityStructure.vehicleShop.models.vehicle.Vehicle;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._01HighQualityStructure.vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop {
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();
        for (Tool tool : tools) {
            while (worker.canWork() && !tool.isUnfit() && !vehicle.reached()) {
                worker.working();
                tool.decreasesPower();
                vehicle.making();
            }
        }
    }
}
