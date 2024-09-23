package _1ProgrammingBasicsWithJavaMay2023._3ConditionalStatementsAdvanced._3MoreExercise;

import java.util.Scanner;

public class _07SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        String typeOfGroup = scanner.nextLine();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfStay = Integer.parseInt(scanner.nextLine());
        double pricePerNight = 0.00;
        double priceForWholeStay = 0.00;
        String typeOfSport = "";
        if (season.equals("Winter")) {
            if (typeOfGroup.equals("boys")) {
                pricePerNight = numberOfStudents * 9.60;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Judo";
            } else if (typeOfGroup.equals("girls")) {
                pricePerNight = numberOfStudents * 9.60;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Gymnastics";
            } else if (typeOfGroup.equals("mixed")) {
                pricePerNight = numberOfStudents * 10.00;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Ski";
            }
        } else if (season.equals("Spring")) {
            if (typeOfGroup.equals("boys")) {
                pricePerNight = numberOfStudents * 7.20;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Tennis";
            } else if (typeOfGroup.equals("girls")) {
                pricePerNight = numberOfStudents * 7.20;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Athletics";
            } else if (typeOfGroup.equals("mixed")) {
                pricePerNight = numberOfStudents * 9.50;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Cycling";
            }
        } else if (season.equals("Summer")) {
            if (typeOfGroup.equals("boys")) {
                pricePerNight = numberOfStudents * 15.00;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Football";
            } else if (typeOfGroup.equals("girls")) {
                pricePerNight = numberOfStudents * 15.00;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Volleyball";
            } else if (typeOfGroup.equals("mixed")) {
                pricePerNight = numberOfStudents * 20.00;
                priceForWholeStay = pricePerNight * numberOfStay;
                typeOfSport = "Swimming";
            }
        }
        if (numberOfStudents >= 50) {
            priceForWholeStay = priceForWholeStay * 0.50;
        } else if (numberOfStudents >= 20 && numberOfStudents < 50) {
            priceForWholeStay = priceForWholeStay * 0.85;
        } else if (numberOfStudents >= 10 && numberOfStudents < 20) {
            priceForWholeStay = priceForWholeStay * 0.95;
        }
        System.out.printf("%s %.2f lv.", typeOfSport, priceForWholeStay);
    }
}
