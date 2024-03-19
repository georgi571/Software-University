package _0Softuniada._2017;

import java.util.Arrays;
import java.util.Scanner;

public class _01SumTo13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        boolean isFind = false;
        for (int i = 0; i < 2; i++) {
            n[0] *= -1;
            for (int j = 0; j < 2; j++) {
                n[1] *= -1;
                for (int k = 0; k < 2; k++) {
                    n[2] *= -1;
                    if (n[0] + n[1] + n[2] == 13) {
                        isFind = true;
                    }
                }
            }
        }
        if (isFind) {
            System.out.printf("Yes%n");
        } else {
            System.out.printf("No%n");
        }
    }
}
