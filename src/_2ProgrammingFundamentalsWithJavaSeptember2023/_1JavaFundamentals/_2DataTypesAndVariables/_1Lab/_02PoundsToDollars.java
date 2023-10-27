package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._1Lab;

import java.util.Scanner;

public class _02PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pounds = Double.parseDouble(scanner.nextLine());
        double dollars = pounds * 1.36;
        System.out.printf("%.3f",dollars);
    }
}
