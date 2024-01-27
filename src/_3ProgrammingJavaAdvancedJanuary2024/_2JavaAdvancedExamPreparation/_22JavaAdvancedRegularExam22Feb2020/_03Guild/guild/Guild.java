package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._22JavaAdvancedRegularExam22Feb2020._03Guild.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                return this.roster.remove(player);
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                if (!this.roster.get(i).getRank().equals("Member")) {
                    this.roster.get(i).setRank("Member");
                }
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                if (!this.roster.get(i).getRank().equals("Trial")) {
                    this.roster.get(i).setRank("Trial");
                }
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> playerList = new ArrayList<>();
        for (Player player : this.roster) {
            if (player.getClazz().equals(clazz)) {
                playerList.add(player);
            }
        }
        this.roster.removeAll(playerList);
        Player[] returnPlayer = new Player[playerList.size()];
        for (int i = 0; i < playerList.size(); i++) {
            returnPlayer[i] = playerList.get(i);
        }
        return returnPlayer;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Players in the guild: %s:%n",this.name)).trimToSize();
        for (Player player : this.roster) {
            stringBuilder.append(String.format("%s%n",player.toString()));
        }
        return stringBuilder.toString().trim();
    }
}
