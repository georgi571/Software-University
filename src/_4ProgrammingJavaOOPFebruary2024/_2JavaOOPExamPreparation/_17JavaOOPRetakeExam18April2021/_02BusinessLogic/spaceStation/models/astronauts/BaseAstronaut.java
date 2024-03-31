package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.bags.Backpack;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.bags.Bag;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.common.ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.common.ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.oxygen = oxygen;
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        this.oxygen -= 10;
        if (this.oxygen < 0){
            this.oxygen = 0;
        }
    }
}
