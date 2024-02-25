package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.entities.gameplay;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.entities.equipment.Equipment;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.entities.team.Team;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._01HighQualityStructure.handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;

public class BaseGameplay implements Gameplay {
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
    }

    public void setName(String name) {
        if (name == null && name.trim().isEmpty()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public int allProtection() {
        int protection = 0;
        for (Equipment equipment : equipments) {
            protection += equipment.getProtection();
        }
        return protection;
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        for (Team team : teams) {
            team.play();
        }
    }

    @Override
    public Collection<Team> getTeam() {
        return Collections.unmodifiableCollection(teams);
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return Collections.unmodifiableCollection(equipments);
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return String.format("%s %s%nTeam: %s%nEquipment: %d, Protection: %d%n",
                this.name, this.getClass().getSimpleName(),
                this.teams.stream().map(Team::getName).collect(Collectors.joining(" ")),
                this.equipments.size(), allProtection());
    }
}
