package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._1ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class _01TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceOfTennisRacket = Double.parseDouble(scanner.nextLine());
        int numberOfTennisRackets = Integer.parseInt(scanner.nextLine());
        int numberSportShoes = Integer.parseInt(scanner.nextLine());
        double priceOfSportShoes = priceOfTennisRacket * 1/6;
        double sumForTennisRackets = priceOfTennisRacket * numberOfTennisRackets;
        double sumForSportShoes = priceOfSportShoes * numberSportShoes;
        double sumForRacketsAndShoes = sumForSportShoes + sumForTennisRackets;
        double otherEqupment = sumForRacketsAndShoes * 0.20;
        double totalSum = sumForRacketsAndShoes + otherEqupment;
        double priceForDjokovic = Math.floor(totalSum * 1/8);
        double priceForSponsors = Math.ceil(totalSum * 7/8);
        System.out.printf("Price to be paid by Djokovic %.0f%n", priceForDjokovic);
        System.out.printf("Price to be paid by sponsors %.0f%n", priceForSponsors);
    }
}
