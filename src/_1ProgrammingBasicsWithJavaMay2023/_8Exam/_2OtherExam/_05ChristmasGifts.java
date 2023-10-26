package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _05ChristmasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int kids = 0;
        int adults = 0;
        while (!command.equals("Christmas")) {
            int years = Integer.parseInt(command);
            if (years <= 16) {
                kids++;
            } else if (years > 16) {
                adults++;
            }
            command = scanner.nextLine();
        }
        int priceForToys = kids * 5;
        int priceForSweaters = adults * 15;
        System.out.printf("Number of adults: %d%n", adults);
        System.out.printf("Number of kids: %d%n", kids);
        System.out.printf("Money for toys: %d%n", priceForToys);
        System.out.printf("Money for sweaters: %d%n", priceForSweaters);
    }
}