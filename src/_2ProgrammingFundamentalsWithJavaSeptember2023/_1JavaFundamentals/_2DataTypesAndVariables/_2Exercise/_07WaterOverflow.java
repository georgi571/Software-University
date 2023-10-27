package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._2Exercise;

import java.util.Scanner;

public class _07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = 255;
        int n = Integer.parseInt(scanner.nextLine());
        int litterInTank = 0;
        for (int i = 1; i <= n ; i++) {
            int litterOfWater = Integer.parseInt(scanner.nextLine());
            if (capacity >= litterOfWater) {
                capacity -= litterOfWater;
                litterInTank += litterOfWater;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.printf("%d", litterInTank);
    }
}

