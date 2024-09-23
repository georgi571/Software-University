package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._3MoreExercise;

import java.util.Scanner;

public class _02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfHoliday = Integer.parseInt(scanner.nextLine());
        int year = 365;
        int norm = 30000;
        int workingDays = year - numbersOfHoliday;
        int playInWorkingDay = workingDays * 63;
        int playInHoliday = numbersOfHoliday * 127;
        int totalTimeToPlay = playInHoliday + playInWorkingDay;
        int diff = Math.abs(totalTimeToPlay - norm);
        int hours = diff / 60;
        int minutes = diff % 60;
        if (totalTimeToPlay > norm) {
            System.out.printf("Tom will run away%n%d hours and %d minutes more for play", hours, minutes);
        } else {
            System.out.printf("Tom sleeps well%n%d hours and %d minutes less for play", hours, minutes);
        }
    }
}
