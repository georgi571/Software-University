package _0Softuniada._2021;

import java.util.Scanner;

public class _2EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int number = 1;
            for (int j = 0; j < n; j++) {
                if (j < n - i) {
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append(String.format("%d", number++));
                }
            }
            number -= 2;
            for (int j = i; j > 1; j--) {
                stringBuilder.append(String.format("%d", number--));
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.printf("%s", stringBuilder.toString());
    }
}
