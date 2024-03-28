package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.player;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {
    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, double kg, int strength) {
        this.setName(name);
        this.setNationality(nationality);
        this.kg = kg;
        this.setStrength(strength);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;
    }

    @Override
    public abstract void stimulation();

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }
}
