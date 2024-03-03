package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.players;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.guns.Gun;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.repositories.interfaces.Repository;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.common.ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.common.ExceptionMessages.PLAYER_NULL_USERNAME;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    public BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        this.lifePoints -= points;
        if (this.lifePoints < 0) {
            this.lifePoints = 0;
        }
    }
}
