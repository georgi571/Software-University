package _1ProgrammingBasicsWithJavaMay2023._6NestedLoops._2Exercise;

import java.util.Scanner;

public class _06CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int allTicketsSold = 0;
        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;
        while (!command.equals("Finish")) {
            String movieName = command;
            int seatsFree = Integer.parseInt(scanner.nextLine());
            int soldTicketsCounter = 0;

            String ticketsCommand = scanner.nextLine();
            while (!ticketsCommand.equals("End")) {
                String ticketType = ticketsCommand;
                soldTicketsCounter++;
                allTicketsSold++;
                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        break;
                    case "standard":
                        standardTickets++;
                        break;
                    case "kid":
                        kidTickets++;
                        break;
                }
                if (soldTicketsCounter == seatsFree) {
                    break;
                }

                ticketsCommand = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", movieName, 1.0 * soldTicketsCounter / seatsFree * 100);

            command = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", allTicketsSold);
        System.out.printf("%.2f%% student tickets.%n", 1.0 * studentTickets / allTicketsSold * 100);
        System.out.printf("%.2f%% standard tickets.%n", 1.0 * standardTickets / allTicketsSold * 100);
        System.out.printf("%.2f%% kids tickets.%n", 1.0 * kidTickets / allTicketsSold * 100);
    }
}