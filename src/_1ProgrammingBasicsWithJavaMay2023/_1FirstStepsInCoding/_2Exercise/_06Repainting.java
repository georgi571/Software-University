package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._2Exercise;

import java.util.Scanner;

public class _06Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plasticMeters = Integer.parseInt(scanner.nextLine());
        int paintLiters = Integer.parseInt(scanner.nextLine());
        int thinnerLiters = Integer.parseInt(scanner.nextLine());
        int workersHours = Integer.parseInt(scanner.nextLine());
        double plasticSum = (plasticMeters + 2) * 1.50;
        double paintSum = (paintLiters + (paintLiters * 0.10)) * 14.50;
        double thinnerSum = thinnerLiters * 5.00;
        double sumMaterials = plasticSum + paintSum + thinnerSum + 0.40;
        double priceForWorkersPerHour = sumMaterials * 0.30;
        double workersTotalPrice = priceForWorkersPerHour * workersHours;
        double totalCost = workersTotalPrice + sumMaterials;
        System.out.println(totalCost);

    }
}
