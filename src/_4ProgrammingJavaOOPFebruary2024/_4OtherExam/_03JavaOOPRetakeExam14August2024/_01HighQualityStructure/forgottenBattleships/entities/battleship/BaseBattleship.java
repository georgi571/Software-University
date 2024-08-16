package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battleship;

import static _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.common.ExceptionMessages.SHIP_NAME_NULL_OR_EMPTY;

public abstract class BaseBattleship implements Battleship {
    private String name;
    private int health;
    private int ammunition;
    private int hitStrength;

    public BaseBattleship(String name, int health, int ammunition, int hitStrength) {
        this.setName(name);
        this.setHealth(health);
        this.ammunition = ammunition;
        this.hitStrength = hitStrength;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getHitStrength() {
        return this.hitStrength;
    }

    @Override
    public int getAmmunition() {
        return this.ammunition;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SHIP_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public void setHitStrength(int hitStrength) {
        this.hitStrength = hitStrength;
    }
}
