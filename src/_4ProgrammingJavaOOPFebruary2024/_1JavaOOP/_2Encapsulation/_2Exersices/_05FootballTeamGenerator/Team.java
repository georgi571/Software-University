package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._2Exersices._05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.printf("A name should not be empty.%n");
        }
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean isPlayerRemoved = false;
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                this.players.remove(player);
                isPlayerRemoved = true;
                break;
            }
        }
        if (!isPlayerRemoved) {
            System.out.printf("Player %s is not in %s team.%n", name, getName());
        }
    }

    public double getRating() {
        if (this.players.isEmpty()) {
            return 0;
        }
        double rating = 0;
        for (Player player : this.players) {
            rating += player.overallSkillLevel();
        }
        return Math.round(rating / this.players.size());
    }

}
