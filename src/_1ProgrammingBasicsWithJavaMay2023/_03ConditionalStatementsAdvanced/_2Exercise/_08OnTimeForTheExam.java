package _1ProgrammingBasicsWithJavaMay2023._03ConditionalStatementsAdvanced._2Exercise;

import java.util.Scanner;

public class _08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hoursOfExam = Integer.parseInt(scanner.nextLine());
        int minutesOfExam = Integer.parseInt(scanner.nextLine());
        int hoursOfArrival = Integer.parseInt(scanner.nextLine());
        int minutesOfArrival = Integer.parseInt(scanner.nextLine());
        int timeForExam = (hoursOfExam * 60) + minutesOfExam;
        int timeForArrival = (hoursOfArrival * 60) + minutesOfArrival;
        int diff = Math.abs(timeForArrival - timeForExam);
        if (timeForArrival > timeForExam) {
            System.out.println("Late");
            if (diff >= 60) {
                int hours = diff / 60;
                int minutes = diff % 60;
                System.out.printf("%d:%02d hours after the start", hours, minutes);
            } else {
                System.out.printf("%d minutes after the start", diff);
            }
        } else if (timeForArrival == timeForExam || diff <= 30) {
            System.out.println("On Time");
            if (diff >= 1 && diff <= 30) {
                System.out.printf("%d minutes before the start", diff);
            }
        } else {
            System.out.println("Early");
            if (diff >= 60) {
                int hours = diff / 60;
                int minutes = diff % 60;
                System.out.printf("%d:%02d hours before the start", hours, minutes);
            } else {
                System.out.printf("%d minutes before the start", diff);
            }
        }
    }
}
