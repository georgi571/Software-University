package _1ProgrammingBasicsWithJavaMay2023._4ForLoop._2Exercise;

import java.util.Scanner;

public class _08TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTournaments = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());
        int winningPoints = 0;
        int wins = 0;
        for (int i = 1; i <= numberOfTournaments; i++) {
            String stageOfTournament = scanner.nextLine();
            if (stageOfTournament.equals("W")) {
                winningPoints += 2000;
                wins += 1;
            } else if (stageOfTournament.equals("F")) {
                winningPoints += 1200;
            } else if (stageOfTournament.equals("SF")) {
                winningPoints += 720;
            }
        }
        int finalPoints = startingPoints + winningPoints;
        double avaragePoints = Math.floor(winningPoints / numberOfTournaments);
        double percent = 1.0 * wins / numberOfTournaments * 100;
        System.out.printf("Final points: %d%n", finalPoints);
        System.out.printf("Average points: %.0f%n", avaragePoints);
        System.out.printf("%.2f%%%n",percent);
    }
}
