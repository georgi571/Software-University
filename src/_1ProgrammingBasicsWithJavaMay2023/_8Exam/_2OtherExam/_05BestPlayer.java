package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _05BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String nameOfBestPlayer = "";
        int numberOfGoalsForBestPlayer = 0;
        boolean isValid = false;
        while (!command.equals("END")) {
            String nameOfFootballPlayer = command;
            int numberOfScoreGoals = Integer.parseInt(scanner.nextLine());
            if (numberOfScoreGoals > numberOfGoalsForBestPlayer) {
                nameOfBestPlayer = nameOfFootballPlayer;
                numberOfGoalsForBestPlayer = numberOfScoreGoals;
            }
            if (numberOfScoreGoals >= 10) {
                isValid = true;
                break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", nameOfBestPlayer);
        if (numberOfGoalsForBestPlayer >= 3){
            System.out.printf("He has scored %d goals and made a hat-trick !!!", numberOfGoalsForBestPlayer);
        } else {
            System.out.printf("He has scored %d goals.", numberOfGoalsForBestPlayer);
        }
    }
}