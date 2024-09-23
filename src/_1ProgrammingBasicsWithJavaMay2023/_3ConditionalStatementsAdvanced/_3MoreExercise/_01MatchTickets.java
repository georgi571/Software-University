package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _01MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String ticketsType = scanner.nextLine();
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        double transportCost = 0.0;
        double tiketPrice = 0.0;
        if (numberOfPeople >= 1 && numberOfPeople <= 4) {
            transportCost = 0.75 * budget;
        } else if (numberOfPeople >= 5 && numberOfPeople <= 9) {
            transportCost = 0.60 * budget;
        } else if (numberOfPeople >= 10 && numberOfPeople <= 24) {
            transportCost = 0.50 * budget;
        } else if (numberOfPeople >= 25 && numberOfPeople <= 49) {
            transportCost = 0.40 * budget;
        } else if (numberOfPeople > 50) {
            transportCost = 0.25 * budget;
        }
        budget = budget - transportCost;
        double totalTicketCost = 0.0;
        if (ticketsType.equals("VIP")) {
            tiketPrice = 499.99;
            totalTicketCost = tiketPrice * numberOfPeople;
        } else if (ticketsType.equals("Normal")) {
            tiketPrice = 249.99;
            totalTicketCost = tiketPrice * numberOfPeople;
        }
        Double diff = Math.abs(totalTicketCost - budget);
        if (budget >= totalTicketCost) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}
