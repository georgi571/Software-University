package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._1BasicSyntaxConditionalStatementsAndLoops._1Lab;

import java.util.Scanner;

public class _11MultiplicationTable20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        for (int i = number2; i <= 10 ; i++) {
            int sum = number1 * i;
            System.out.printf("%d X %d = %d%n",number1, i, sum);
        }
        if (number2 > 10) {
            int sum2 = number1 * number2;
            System.out.printf("%d X %d = %d%n",number1, number2, sum2);
        }
    }
}
