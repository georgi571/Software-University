package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _01SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfTheMovie = scanner.nextLine();
        int numberOfSeasons = Integer.parseInt(scanner.nextLine());
        int numberOfEpisodes = Integer.parseInt(scanner.nextLine());
        double timePerEpisode = Double.parseDouble(scanner.nextLine());
        double timeForAdvertisement = timePerEpisode * 0.20;
        double extraTimePerSpecialEpisode = 10.00;
        double timeForEpisodePlusAdvertisement = timePerEpisode + timeForAdvertisement;
        double oneSeasonTimeInMinutes = (numberOfEpisodes * timeForEpisodePlusAdvertisement) + extraTimePerSpecialEpisode;
        double timeForAllSeason = Math.floor(numberOfSeasons * oneSeasonTimeInMinutes);
        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", nameOfTheMovie, timeForAllSeason);
    }
}
