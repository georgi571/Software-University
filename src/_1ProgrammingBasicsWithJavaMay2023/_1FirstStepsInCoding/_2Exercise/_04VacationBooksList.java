package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._2Exercise;

import java.util.Scanner;

public class _04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pagesCount = Integer.parseInt(scanner.nextLine());
        int pagesFor1Hour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int hoursAllToRead = pagesCount / pagesFor1Hour;
        int hoursPerDay = hoursAllToRead / days;
        System.out.println(hoursPerDay);
    }
}
