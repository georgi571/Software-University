package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.models.discoverer;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.models.museum.Museum;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022._01HighQualityStructure.goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {
    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {
        this.energy -= 15;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }
}
