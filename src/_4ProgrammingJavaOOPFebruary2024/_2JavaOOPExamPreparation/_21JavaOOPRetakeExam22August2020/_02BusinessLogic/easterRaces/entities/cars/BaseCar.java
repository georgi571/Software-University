package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.entities.cars;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020._02BusinessLogic.easterRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    public void setModel(String model) {
        if (model == null || model.trim().length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimeters / this.horsePower * laps;
    }
}
