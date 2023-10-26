package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._1ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class _02Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minutes = Integer.parseInt(scanner.nextLine());
        int seconds = Integer.parseInt(scanner.nextLine());
        double longDistance = Double.parseDouble(scanner.nextLine());
        int secondsPer100Meters = Integer.parseInt(scanner.nextLine());
        int minutesinseconds = minutes * 60;
        int controlTime = seconds + minutesinseconds;
        double timeToPass = (longDistance / 100) * secondsPer100Meters;
        double timeFaster = longDistance / 120;
        double savedTime = timeFaster * 2.5;
        double totalTime = timeToPass - savedTime;
        double diff = Math.abs(controlTime - totalTime);
        if (totalTime <= controlTime) {
            System.out.printf("Marin Bangiev won an Olympic quota!%n");
            System.out.printf("His time is %.3f.%n", totalTime);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", diff);
        }
    }
}
