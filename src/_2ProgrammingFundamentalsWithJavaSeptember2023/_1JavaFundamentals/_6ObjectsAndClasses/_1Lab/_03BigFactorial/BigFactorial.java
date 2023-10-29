package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._1Lab._03BigFactorial;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n ; i++) {
            result = result.multiply(BigInteger.valueOf(i)) ;
        }
        System.out.printf("%d", result);
    }
}
