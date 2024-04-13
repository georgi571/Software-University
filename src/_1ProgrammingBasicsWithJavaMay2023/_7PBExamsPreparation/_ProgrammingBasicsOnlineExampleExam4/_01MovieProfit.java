package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _01MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfMovie = scanner.nextLine();
        int numberOfDays = Integer.parseInt(scanner.nextLine());
        int numberOfTickets = Integer.parseInt(scanner.nextLine());
        double pricePerTicket = Double.parseDouble(scanner.nextLine());
        int percentForCinema = Integer.parseInt(scanner.nextLine());
        double earnedMoneyPerDay = numberOfTickets * pricePerTicket;
        double earnedMoneyForAllDays = numberOfDays * earnedMoneyPerDay;
        double moneyLeftForCinema = earnedMoneyForAllDays * percentForCinema / 100;
        double netProfitFromMovie = earnedMoneyForAllDays - moneyLeftForCinema;
        System.out.printf("The profit from the movie %s is %.2f lv.", nameOfMovie, netProfitFromMovie);
    }
}
