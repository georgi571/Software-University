package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battlezone;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battleship.Battleship;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.common.ExceptionMessages.*;

public class BattleZoneImpl implements BattleZone {
    private String name;
    private int capacity;
    private Collection<Battleship> ships;

    public BattleZoneImpl(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.ships = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void addBattleship(Battleship ship) {
        if (capacity == this.ships.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        if (ship.getHealth() <= 0) {
            throw new IllegalArgumentException(SHIP_HEALTH_NULL_OR_EMPTY);
        }
        this.ships.add(ship);
    }

    @Override
    public Battleship getBattleshipByName(String battleshipName) {
        for (Battleship ship : this.ships) {
            if (ship.getName().equals(battleshipName)) {
                return ship;
            }
        }
        return null;
    }

    @Override
    public void removeBattleShip(Battleship ship) {
        this.ships.remove(ship);
    }

    @Override
    public Collection<Battleship> getShips() {
        return this.ships;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(BATTLE_ZONE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
