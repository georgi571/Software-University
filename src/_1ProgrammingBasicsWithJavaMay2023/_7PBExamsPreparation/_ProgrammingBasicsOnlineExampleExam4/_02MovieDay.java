package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _02MovieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int timeForMovie = Integer.parseInt(scanner.nextLine());
        int numberOfScenes = Integer.parseInt(scanner.nextLine());
        int timesPerScenes = Integer.parseInt(scanner.nextLine());
        double preparing = timeForMovie * 0.15;
        int timeForAllScenes = numberOfScenes * timesPerScenes;
        double fullTimeForMovie = timeForAllScenes + preparing;
        double diff = Math.abs(fullTimeForMovie - timeForMovie);
        if (fullTimeForMovie <= timeForMovie) {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", diff);
        } else {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", diff);
        }
    }
}
