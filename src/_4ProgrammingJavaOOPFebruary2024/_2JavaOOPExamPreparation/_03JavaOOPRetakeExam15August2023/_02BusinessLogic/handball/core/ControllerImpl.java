package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.equipment.ElbowPad;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.equipment.Equipment;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.equipment.Kneepad;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.gameplay.Gameplay;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.gameplay.Indoor;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.gameplay.Outdoor;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.team.Bulgaria;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.team.Germany;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.entities.team.Team;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.repositories.EquipmentRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023._02BusinessLogic.handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository equipmentRepository;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipmentRepository = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        if (gameplayType.equals("Outdoor")) {
            gameplay = new Outdoor(gameplayName);
        } else if (gameplayType.equals("Indoor")) {
            gameplay = new Indoor(gameplayName);
        } else {
            throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }
        this.gameplays.add(gameplay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment;
        if (equipmentType.equals("Kneepad")) {
            equipment = new Kneepad();
        } else if (equipmentType.equals("ElbowPad")) {
            equipment = new ElbowPad();
        } else {
            throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }
        this.equipmentRepository.add(equipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipment = this.equipmentRepository.findByType(equipmentType);
        if (equipment == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }
        for (Gameplay gameplay : this.gameplays) {
            if (gameplay.getName().equals(gameplayName)) {
                gameplay.addEquipment(equipment);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;
        if (teamType.equals("Bulgaria")) {
            team = new Bulgaria(teamName, country, advantage);
        } else if (teamType.equals("Germany")) {
            team = new Germany(teamName, country, advantage);
        } else {
            throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }
        for (Gameplay gameplay : this.gameplays) {
            if (gameplay.getName().equals(gameplayName)) {
                if (teamType.equals("Bulgaria")) {
                    if (gameplay.getClass().getSimpleName().equals("Indoor")) {
                        return String.format(GAMEPLAY_NOT_SUITABLE);
                    } else if (gameplay.getClass().getSimpleName().equals("Outdoor")) {
                        gameplay.addTeam(team);
                        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
                    }
                }
                if (teamType.equals("Germany")) {
                    if (gameplay.getClass().getSimpleName().equals("Outdoor")) {
                        return String.format(GAMEPLAY_NOT_SUITABLE);
                    } else if (gameplay.getClass().getSimpleName().equals("Indoor")) {
                        gameplay.addTeam(team);
                        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String playInGameplay(String gameplayName) {
        int count = 0;
        for (Gameplay gameplay : this.gameplays) {
            if (gameplay.getName().equals(gameplayName)) {
                for (Team team : gameplay.getTeam()) {
                    team.play();
                    count++;
                }
            }
        }
        return String.format(TEAMS_PLAYED, count);
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        int sum = 0;
        for (Gameplay gameplay : this.gameplays) {
            if (gameplay.getName().equals(gameplayName)) {
                for (Team team : gameplay.getTeam()) {
                    sum += team.getAdvantage();
                }
            }
        }
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (Gameplay gameplay : this.gameplays) {
            statistics.append(String.format("%s %s", gameplay.getName(), gameplay.getClass().getSimpleName())).append(System.lineSeparator());
            Collection<Team> teams = gameplay.getTeam();
            statistics.append("Team:");
            if (teams.isEmpty()) {
                statistics.append(" None");
            } else {
                for (Team team : teams) {
                    statistics.append(String.format(" %s", team.getName()));
                }
            }
            statistics.append(System.lineSeparator());
            statistics.append(String.format("Equipment: %d, Protection: %d", gameplay.getEquipments().size(), gameplay.allProtection())).append(System.lineSeparator());
        }

        return statistics.toString().trim();
    }
}