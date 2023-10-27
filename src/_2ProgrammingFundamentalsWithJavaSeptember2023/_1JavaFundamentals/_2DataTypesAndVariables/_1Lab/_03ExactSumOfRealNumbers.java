package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._2DataTypesAndVariables._1Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class _03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal result = new BigDecimal(0);
        for (int i = 0; i < n; i++) {
            BigDecimal number = new BigDecimal(scanner.nextLine());
            result = result.add(number);
        }
            System.out.println(result);
    }
}
