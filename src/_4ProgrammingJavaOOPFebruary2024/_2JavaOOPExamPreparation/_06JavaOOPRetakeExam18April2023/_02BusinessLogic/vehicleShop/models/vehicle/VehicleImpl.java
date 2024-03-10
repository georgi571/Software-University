package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.models.vehicle;


import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.common.ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._02BusinessLogic.vehicleShop.common.ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO;

public class VehicleImpl implements Vehicle {
    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getStrengthRequired() {
        return strengthRequired;
    }

    public void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.strengthRequired == 0;
    }

    @Override
    public void making() {
        this.strengthRequired -= 5;
        if (this.strengthRequired < 0) {
            this.strengthRequired = 0;
        }
    }


}
