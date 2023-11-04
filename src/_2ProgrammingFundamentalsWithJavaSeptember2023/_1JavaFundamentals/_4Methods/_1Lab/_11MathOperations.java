package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._1Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int number2 = Integer.parseInt(scanner.nextLine());
        calculation(number1, operator, number2);
    }
    private static void calculation (int number1, String operator, int number2) {
        double result = 0.0;
        if (operator.equals("+")) {
            result = number1 + number2;
        } else if (operator.equals("-")) {
            result = number1 - number2;
        } else if (operator.equals("*")) {
            result = number1 * number2;
        } else if (operator.equals("/")) {
            result = number1 / number2;
        }
        System.out.println(new DecimalFormat("0.####").format(result));
    }
}
