package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.core;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.common.ConstantMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.common.ExceptionMessages;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.entities.battleship.Battleship;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.entities.battleship.PirateBattleship;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.entities.battleship.RoyalBattleship;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.entities.battlezone.BattleZone;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.entities.battlezone.BattleZoneImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private Collection<BattleZone> battleZones;

    public ControllerImpl() {
        this.battleZones = new ArrayList<>();
    }


    @Override
    public String addBattleZone(String battleZoneName, int capacity) {
        for (BattleZone battleZone : this.battleZones) {
            if (battleZone.getName().equals(battleZoneName)) {
                throw new IllegalArgumentException(ExceptionMessages.BATTLE_ZONE_EXISTS);
            }
        }
        BattleZone battleZone = new BattleZoneImpl(battleZoneName, capacity);
        this.battleZones.add(battleZone);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BATTLE_ZONE, battleZoneName);
    }

    @Override
    public BattleZone getBattleZoneByName(String battleZoneName) {
        for (BattleZone battleZone : this.battleZones) {
            if (battleZone.getName().equals(battleZoneName)) {
                return battleZone;
            }
        }
        return null;
    }

    @Override
    public String addBattleshipToBattleZone(String battleZoneName, String shipType, String shipName, int health) {
        BattleZone battleZone = null;
        for (BattleZone zone : this.battleZones) {
            if (zone.getName().equals(battleZoneName)) {
                battleZone = zone;
            }
        }
        if (battleZone == null) {
            throw new NullPointerException(ExceptionMessages.BATTLE_ZONE_DOES_NOT_EXISTS);
        }
        Battleship battleship = null;
        if (shipType.equals("RoyalBattleship")) {
            battleship = new RoyalBattleship(shipName, health);
        } else if (shipType.equals("PirateBattleship")) {
            battleship = new PirateBattleship(shipName, health);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SHIP_TYPE);
        }
        for (Battleship ship : battleZone.getShips()) {
            if (ship.getName().equals(shipName)) {
                throw new IllegalArgumentException(ExceptionMessages.SHIP_EXISTS);
            }
        }
        battleZone.addBattleship(battleship);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SHIP, shipType, shipName, battleZoneName);
    }

    @Override
    public String startBattle(String battleZoneName, String attackingShip, String shipUnderAttack) {
        StringBuilder stringBuilder = new StringBuilder();
        BattleZone battleZone = null;
        Battleship attacker = null;
        Battleship defender = null;
        for (BattleZone zone : this.battleZones) {
            if (zone.getName().equals(battleZoneName)) {
                battleZone = zone;
            }
        }
        if (battleZone.getShips().size() < 2) {
            throw new IllegalArgumentException(ExceptionMessages.INSUFFICIENT_COUNT);
        }
        for (Battleship ship : battleZone.getShips()) {
            if (ship.getName().equals(attackingShip)) {
                attacker = ship;
            } else if (ship.getName().equals(shipUnderAttack)) {
                defender = ship;
            }
        }
        if (attacker == null || defender == null) {
            throw new NullPointerException(ExceptionMessages.NON_EXISTING_SHIP);
        }
        if (attacker.getAmmunition() >= attacker.getHitStrength()) {
            attacker.attack(defender);
            defender.takeDamage(attacker);
        }
        if (defender.getHealth() <= 0) {
            battleZone.removeBattleShip(defender);
            System.out.printf(ExceptionMessages.SHIP_LOST_AND_SUNK + "%n", shipUnderAttack);
        }
        if (attacker.getAmmunition() <= 0 && attacker.getHealth() > 0) {
            System.out.printf(String.format(ExceptionMessages.SHIP_RUNS_OUT_OF_AMMO  + "%n", attackingShip));
        }
        if (!battleZone.getShips().isEmpty()) {
            stringBuilder.append(String.format(ConstantMessages.BATTLE_CONTINUES, battleZoneName));
            for (Battleship ship : battleZone.getShips()) {
                stringBuilder.append(String.format("%s, ", ship.getName()));
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (BattleZone battleZone : this.battleZones) {
            stringBuilder.append(String.format(ConstantMessages.SHIPS_IN_BATTLE_ZONE, battleZone.getName())).append(System.lineSeparator());
            if (battleZone.getShips().size() == 1) {
                for (Battleship ship : battleZone.getShips()) {
                    stringBuilder.append(String.format(ConstantMessages.SHIP_WINS, ship.getName()));
                }
            } else {
                for (Battleship ship : battleZone.getShips()) {
                    stringBuilder.append(String.format(ConstantMessages.SHIP_INFO, ship.getName(), ship.getHealth(), ship.getAmmunition())).append(System.lineSeparator());
                }
            }
        }
        return stringBuilder.toString().trim();
    }
}
