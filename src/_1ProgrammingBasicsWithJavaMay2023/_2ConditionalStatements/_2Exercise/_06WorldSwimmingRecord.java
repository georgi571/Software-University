package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._2Exercise;

import java.util.Scanner;

public class _06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timePer1Meter = Double.parseDouble(scanner.nextLine());
        double timeForSwim = distance * timePer1Meter;
        double sectorsInDistance = Math.floor(distance / 15);
        double slowingTime= sectorsInDistance * 12.5;
        timeForSwim = timeForSwim + slowingTime;
        double diff = timeForSwim - record;
        if (timeForSwim < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeForSwim);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", diff);
        }
    }
}
