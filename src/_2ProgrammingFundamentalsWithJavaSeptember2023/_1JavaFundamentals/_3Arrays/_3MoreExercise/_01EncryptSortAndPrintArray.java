package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._3MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arrays = new int[n];
        for (int i = 0; i < n ; i++) {
            String names = scanner.nextLine();
            for (int j = 0; j < names.length(); j++) {
                char currentSymbol = names.charAt(j);
                if (currentSymbol == 65 ||
                currentSymbol == 69 ||
                currentSymbol == 73 ||
                currentSymbol == 79 ||
                currentSymbol == 85 ||
                currentSymbol == 97 ||
                currentSymbol == 101 ||
                currentSymbol == 105 ||
                currentSymbol == 111 ||
                currentSymbol == 117 ) {
                    arrays[i] += currentSymbol * names.length();
                } else {
                    arrays[i] += currentSymbol / names.length();
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int change1 = 0;
                int change2 = 0;
                if (arrays[i] < arrays[j]) {
                    change1 = arrays[i];
                    change2 = arrays[j];
                    arrays[i] = change2;
                    arrays[j] = change1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d%n", arrays[i]);
        }
    }
}
