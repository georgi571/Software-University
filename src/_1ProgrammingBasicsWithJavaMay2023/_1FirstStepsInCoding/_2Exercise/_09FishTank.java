package _11ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._2Exercise;

import java.util.Scanner;

public class _09FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        int volumeInCentimeters = width * height * length;
        double volumeInLiters = volumeInCentimeters * 0.001;
        double volumeLitersWithoutPercent = volumeInLiters - (volumeInLiters * percent/100);
        System.out.println(volumeLitersWithoutPercent);
    }
}
