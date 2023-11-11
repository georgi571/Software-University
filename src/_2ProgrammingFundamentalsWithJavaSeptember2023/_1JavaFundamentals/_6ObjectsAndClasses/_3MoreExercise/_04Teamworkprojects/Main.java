package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._3MoreExercise._04Teamworkprojects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTeams = Integer.parseInt(scanner.nextLine());
        List<Team> teamList = new ArrayList<>();
        for (int i = 1; i <= numberOfTeams; i++) {
            String[] input = scanner.nextLine().split("-");
            String user = input[0];
            String teamName = input[1];
            if (isTeamAvailable(teamList, teamName)) {
                if (isCreatorIsNew(teamList, user)) {
                    Team team = new Team(teamName, user);
                    teamList.add(team);
                    System.out.printf("Team %s has been created by %s!%n", teamName, user);
                } else {
                    System.out.printf("%s cannot create another team!%n", user);
                }
            } else {
                System.out.printf("Team %s was already created!%n", teamName);
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end of assignment")) {
            String[] input = command.split("->");
            String user = input[0];
            String teamName = input[1];
            if (isTeamExist(teamList, teamName)) {
                if (!isMemberExist(teamList,user)) {
                    for (int i = 0; i < teamList.size(); i++) {
                        if (teamList.get(i).getName().equals(teamName)) {
                            teamList.get(i).addMember(user);
                        }
                    }
                } else {
                    System.out.printf("Member %s cannot join team %s!%n", user, teamName);
                }
            } else {
                System.out.printf("Team %s does not exist!%n", teamName);
            }
            command = scanner.nextLine();
        }
        teamList.sort(Comparator.comparing(Team::getName));
        teamList.sort(Comparator.comparing(Team::membersCount).reversed());
        for (Team currentTeam : teamList) {
            currentTeam.getMembers().sort(String::compareTo);
            if (!currentTeam.getMembers().isEmpty()) {
                System.out.printf("%s%n",currentTeam.getName());
                System.out.printf("- %s%n", currentTeam.getCreator());
                for (String member : currentTeam.getMembers()) {
                    System.out.printf("-- %s%n",member);
                }
            }
        }
        System.out.printf("Teams to disband:%n");
        for (Team currentTeam : teamList) {
            if (currentTeam.getMembers().isEmpty()) {
                System.out.printf("%s%n", currentTeam.getName());
            }
        }
    }
    private static boolean isTeamAvailable(List<Team> teams, String newTeam) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equals(newTeam)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCreatorIsNew(List<Team> teams, String newUser) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getCreator().equals(newUser)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isTeamExist(List<Team> teams, String newTeam) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equals(newTeam)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMemberExist(List<Team> teams, String newUser) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getCreator().equals(newUser)) {
                return true;
            }
        }
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getMembers().contains(newUser)) {
                return true;
            }
        }
        return false;
    }
}
