package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _03FilmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projectionName = scanner.nextLine();
        String packageForMovie = scanner.nextLine();
        int numberOfTickets = Integer.parseInt(scanner.nextLine());
        double bill = 0;
        if (projectionName.equals("John Wick")) {
            if (packageForMovie.equals("Drink")) {
                bill = numberOfTickets * 12;
            } else if (packageForMovie.equals("Popcorn")) {
                bill = numberOfTickets * 15;
            } else if (packageForMovie.equals("Menu")) {
                bill = numberOfTickets * 19;
            }
        } else if (projectionName.equals("Star Wars")) {
            if (packageForMovie.equals("Drink")) {
                bill = numberOfTickets * 18;
            } else if (packageForMovie.equals("Popcorn")) {
                bill = numberOfTickets * 25;
            } else if (packageForMovie.equals("Menu")) {
                bill = numberOfTickets * 30;
            }
            if (numberOfTickets >= 4) {
                bill = bill * 0.70;
            }
        } else if (projectionName.equals("Jumanji")) {
            if (packageForMovie.equals("Drink")) {
                bill = numberOfTickets * 9;
            } else if (packageForMovie.equals("Popcorn")) {
                bill = numberOfTickets * 11;
            } else if (packageForMovie.equals("Menu")) {
                bill = numberOfTickets * 14;
            }
            if (numberOfTickets == 2) {
                bill = bill * 0.85;
            }
        }
        System.out.printf("Your bill is %.2f leva.", bill);
    }
}
