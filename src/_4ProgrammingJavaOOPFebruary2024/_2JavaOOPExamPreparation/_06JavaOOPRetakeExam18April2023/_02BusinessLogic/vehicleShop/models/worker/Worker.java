package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.worker;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.tool.Tool;

import java.util.Collection;

public interface Worker {
    void working();

    void addTool(Tool tool);

    boolean canWork();

    String getName();

    int getStrength();

    Collection<Tool> getTools();
}
