package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._2Exercise;

import java.util.Scanner;

public class _04PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());
        int totalSum = 0;
        for (int i = startNumber; i <= endNumber ; i++) {
            System.out.printf("%d ", i);
            totalSum += i;
        }
        System.out.printf("%nSum: %d", totalSum);
    }
}
