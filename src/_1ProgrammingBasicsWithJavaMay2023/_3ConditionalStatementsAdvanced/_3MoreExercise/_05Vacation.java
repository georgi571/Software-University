package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _05Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = "";
        String location = "";
        double price = 0.00;
        if (budget <= 1000) {
            place = "Camp";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.65;
            } else if (season.equals("Winter")) {
                location = "Morocco";
                price = budget * 0.45;
            }
        } else if (budget > 1000 && budget <= 3000) {
            place = "Hut";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.80;
            } else if (season.equals("Winter")) {
                location = "Morocco";
                price = budget * 0.60;
            }
        } else if (budget > 3000) {
            place = "Hotel";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.90;
            } else if (season.equals("Winter")) {
                location = "Morocco";
                price = budget * 0.90;
            }
        }
        System.out.printf("%s - %s - %.2f", location, place, price);
    }
}
