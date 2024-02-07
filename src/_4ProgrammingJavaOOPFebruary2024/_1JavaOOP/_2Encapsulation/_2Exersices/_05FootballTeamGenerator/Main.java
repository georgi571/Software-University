package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._2Exersices._05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split(";");
            if (commandParts[0].equals("Team")) {
                Team team = new Team(commandParts[1]);
                teams.add(team);
            } else if (commandParts[0].equals("Add")) {
                boolean isTeamExist = false;
                for (Team team : teams) {
                    if (team.getName().equals(commandParts[1])) {
                        isTeamExist = true;
                        try {
                            Player player = new Player(commandParts[2], Integer.parseInt(commandParts[3]), Integer.parseInt(commandParts[4]),
                                    Integer.parseInt(commandParts[5]), Integer.parseInt(commandParts[6]) ,Integer.parseInt(commandParts[7]));
                            team.addPlayer(player);
                        } catch (IllegalArgumentException exception) {
                            System.out.printf("%s%n",exception.getMessage());
                        }
                    }
                }
                if (!isTeamExist) {
                    System.out.printf("Team %s does not exist.%n", commandParts[1]);
                }
            } else if (commandParts[0].equals("Remove")) {
                for (Team team : teams) {
                    if (team.getName().equals(commandParts[1])) {
                        team.removePlayer(commandParts[2]);
                    }
                }
            } else if (commandParts[0].equals("Rating")) {
                boolean isTeamExist = false;
                for (Team team : teams) {
                    if (team.getName().equals(commandParts[1])) {
                        isTeamExist = true;
                        System.out.printf("%s - %.0f%n", team.getName(), team.getRating());
                    }
                }
                if (!isTeamExist) {
                    System.out.printf("Team %s does not exist.%n", commandParts[1]);
                }
            }
            command = scanner.nextLine();
        }
    }
}
