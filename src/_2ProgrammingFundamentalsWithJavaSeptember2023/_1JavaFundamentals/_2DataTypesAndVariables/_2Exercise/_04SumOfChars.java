package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._2Exercise;

import java.util.Scanner;

public class _04SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            char charNumber = scanner.nextLine().charAt(0);
            int numberForChar = (int)charNumber;
            sum += numberForChar;
        }
        System.out.printf("The sum equals: %d",sum);
    }
}
