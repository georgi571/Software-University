package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._3MoreExercise;

import java.util.Scanner;

public class _04TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfKm = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();
        double taxiDay = (numberOfKm * 0.79) + 0.70;
        double taxiNight = (numberOfKm * 0.90) + 0.70;
        double bus = numberOfKm * 0.09;
        double train = numberOfKm * 0.06;
        double taxiPrice = 0.0;
        double busPrice = 0.0;
        double trainPrice = 0.0;
        if (numberOfKm >= 100) {
            trainPrice = train;
            System.out.printf("%.2f", trainPrice);
        } else if (numberOfKm >= 20) {
            busPrice = bus;
            System.out.printf("%.2f", busPrice);
        } else {
            if (dayOrNight.equals("day")) {
                taxiPrice = taxiDay;
                System.out.printf("%.2f", taxiPrice);
            } else {
                taxiPrice = taxiNight;
                System.out.printf("%.2f", taxiPrice);
            }
        }
    }
}
