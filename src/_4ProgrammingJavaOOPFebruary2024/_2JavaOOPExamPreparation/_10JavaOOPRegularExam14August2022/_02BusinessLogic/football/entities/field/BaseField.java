package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.field;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.player.Player;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022._02BusinessLogic.football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;


public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        int sumOfEnergy = 0;
        for (Supplement supplement : this.supplements) {
            sumOfEnergy += supplement.getEnergy();
        }
        return sumOfEnergy;
    }

    @Override
    public void addPlayer(Player player) {
        if (players.size() >= this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());
        info.append(String.format("Player:"));
        if (players.isEmpty()) {
            info.append(" none");
        } else {
            for (Player player : this.players) {
                info.append(String.format(" %s", player.getName()));
            }
        }
        info.append(System.lineSeparator());
        info.append(String.format("Supplement: %d", this.supplements.size())).append(System.lineSeparator());
        info.append(String.format("Energy: %d", this.sumEnergy()));
        return info.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(players);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(supplements);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}
