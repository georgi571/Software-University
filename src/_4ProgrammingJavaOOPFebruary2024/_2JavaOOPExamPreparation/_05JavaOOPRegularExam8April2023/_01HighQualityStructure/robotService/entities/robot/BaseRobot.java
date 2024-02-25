package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.entities.robot;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023._01HighQualityStructure.robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot{
    private String name;
    private String kind;
    private int kilograms;
    private double price;

    public BaseRobot(String name, String kind, int kilograms, double price) {
        this.setName(name);
        this.setKind(kind);
        this.setKilograms(kilograms);
        this.setPrice(price);
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        if (kind == null || kind.trim().isEmpty()) {
            throw new NullPointerException(ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    @Override
    public abstract void eating();
}
