package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._2Exercise;

import java.util.Scanner;

public class _02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        while (number > 0) {
            int currentSymbol = number % 10;
            counter += currentSymbol;
            number = number / 10;
        }
        System.out.printf("%d",counter);
    }
}
