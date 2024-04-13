package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _05Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfActors = scanner.nextLine();
        double pointsFromAcademy = Double.parseDouble(scanner.nextLine());
        int numberOfJudges = Integer.parseInt(scanner.nextLine());
        double totalPointsForTheActor = pointsFromAcademy;
        for (int i = 0; i < numberOfJudges; i++) {
            String nameOfTheJudge = scanner.nextLine();
            int nameLength = nameOfTheJudge.length();
            double pointsTheJudgeGive = Double.parseDouble(scanner.nextLine());
            double pointsFromTheJudge = (nameLength * pointsTheJudgeGive) / 2;
            totalPointsForTheActor += pointsFromTheJudge;
            if (totalPointsForTheActor >= 1250.5) {
                break;
            }
        }
        if (totalPointsForTheActor >= 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", nameOfActors, totalPointsForTheActor);
        } else {
            double neededPoints = 1250.5 - totalPointsForTheActor;
            System.out.printf("Sorry, %s you need %.1f more!", nameOfActors, neededPoints);
        }
    }
}
