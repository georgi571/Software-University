package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._2Exercise;

import java.util.Scanner;

public class _09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minedSpicesInFirstDay = Integer.parseInt(scanner.nextLine());
        int dayCounter = 0;
        int totalMinedSpices = 0;
        while (minedSpicesInFirstDay >= 100) {
            totalMinedSpices += minedSpicesInFirstDay - 26;
            dayCounter++;
            minedSpicesInFirstDay -= 10;
            if (minedSpicesInFirstDay < 100) {
                totalMinedSpices -= 26;
            }
        }
        System.out.printf("%d%n%d", dayCounter, totalMinedSpices);
    }
}
