package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.models.diver;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.models.seaCatch.SeaCatch;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.common.ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.common.ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseDiver implements Diver{
    private static final double DROP_OXYGEN = 30;
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
    }



    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null && name.trim().isEmpty()) {
            throw new NullPointerException(DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return 0;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return null;
    }

    @Override
    public void shoot() {
        double newOxygen = this.oxygen;
        newOxygen -= DROP_OXYGEN;
        if (newOxygen < 0) {
            newOxygen = 0;
        }
        this.oxygen = newOxygen;
    }


}
