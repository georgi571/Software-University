package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _04CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String classOfCar = "";
        String typeOfCar = "";
        double priceOfCar = 0.00;
        if (budget <= 100) {
            classOfCar = "Economy class";
            if (season.equals("Summer")) {
                typeOfCar = "Cabrio";
                priceOfCar = budget * 0.35;
            } else if (season.equals("Winter")) {
                typeOfCar = "Jeep";
                priceOfCar = budget * 0.65;
            }
        } else if (budget > 100 && budget <= 500) {
            classOfCar = "Compact class";
            if (season.equals("Summer")) {
                typeOfCar = "Cabrio";
                priceOfCar = budget * 0.45;
            } else if (season.equals("Winter")) {
                typeOfCar = "Jeep";
                priceOfCar = budget * 0.80;
            }
        } else if (budget > 500) {
            classOfCar = "Luxury class";
            typeOfCar = "Jeep";
            priceOfCar = budget * 0.90;
        }
        System.out.printf("%s%n%s - %.2f", classOfCar, typeOfCar, priceOfCar);
    }
}
