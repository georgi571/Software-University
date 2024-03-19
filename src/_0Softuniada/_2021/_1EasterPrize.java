package _0Softuniada._2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1EasterPrize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = n; i <= m; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                    if (count > 1) {
                        break;
                    }
                }
            }
            if (count == 1) {
                primeNumbers.add(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer primeNumber : primeNumbers) {
            stringBuilder.append(primeNumber + " ");
        }
        System.out.printf("%s%n", stringBuilder.toString().trim());
        System.out.printf("The total number of prime numbers between %d to %d is %d", n, m, primeNumbers.size());
    }
}
