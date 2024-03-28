package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.core;


import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.field.ArtificialTurf;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.field.Field;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.field.NaturalGrass;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.player.Men;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.player.Player;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.player.Women;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.supplement.Liquid;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.supplement.Powdered;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.supplement.Supplement;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.repositories.SupplementRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.common.ConstantMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplementRepository;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        this.fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        if (type.equals("Powdered")) {
            supplement = new Powdered();
        } else if (type.equals("Liquid")) {
            supplement = new Liquid();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplementRepository.add(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field findField = null;
        for (Field field : this.fields) {
            if (field.getName().equals(fieldName)) {
                findField = field;
            }
        }
        Supplement supplement = this.supplementRepository.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        findField.addSupplement(supplement);
        this.supplementRepository.remove(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player = null;
        if (playerType.equals("Men")) {
            for (Field field : this.fields) {
                if (field.getName().equals(fieldName)) {
                }
                if (field.getClass().getSimpleName().equals("NaturalGrass")) {
                    player = new Men(playerName, nationality, strength);
                    field.addPlayer(player);
                }
            }
        } else if (playerType.equals("Women")) {
            for (Field field : this.fields) {
                if (field.getName().equals(fieldName)) {
                    if (field.getClass().getSimpleName().equals("ArtificialTurf")) {
                        player = new Women(playerName, nationality, strength);
                        field.addPlayer(player);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        if (player == null) {
            return FIELD_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Collection<Player> players = null;
        for (Field field : this.fields) {
            if (field.getName().equals(fieldName)) {
                players = field.getPlayers();
                break;
            }
        }
        for (Player player : players) {
            player.stimulation();
        }
        return String.format(PLAYER_DRAG, players.size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        int sum = 0;
        for (Field field : this.fields) {
            if (field.getName().equals(fieldName)) {
                for (Player player : field.getPlayers()) {
                    sum += player.getStrength();
                }
            }
        }
        return String.format(STRENGTH_FIELD, fieldName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : this.fields) {
            stringBuilder.append(String.format("%s", field.getInfo())).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
