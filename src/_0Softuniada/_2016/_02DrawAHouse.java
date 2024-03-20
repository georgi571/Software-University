package _0Softuniada._2016;

import java.util.Scanner;

public class _02DrawAHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        int left = n - 2;
        int right = n;
        for (int i = 0; i < n * 2 - 1; i++) {
            if (i == n - 1) {
                stringBuilder.append("*");
            } else {
                stringBuilder.append(".");
            }
        }
        stringBuilder.append(System.lineSeparator());
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n * 2 - 1; i++) {
                if (i == left) {
                    stringBuilder.append("*");
                } else if (i == right) {
                    stringBuilder.append("*");
                } else if (i < left || i >= right) {
                    stringBuilder.append(".");
                } else {
                    if (j != n - 2) {
                        stringBuilder.append(" ");
                    } else {
                        if (i % 2 == 0) {
                            stringBuilder.append("*");
                        } else {
                            stringBuilder.append(" ");
                        }
                    }
                }
            }
            left--;
            right++;
            stringBuilder.append(System.lineSeparator());
        }
        for (int i = 0; i < n * 2 - 1; i++) {
            if (i == 0 || i == n * 2 - 2) {
                stringBuilder.append("+");
            } else {
                stringBuilder.append("-");
            }
        }
        stringBuilder.append(System.lineSeparator());
        for (int j = 0; j < n - 2; j++) {
            for (int i = 0; i < n * 2 - 1; i++) {
                if (i == 0 || i == n * 2 - 2) {
                    stringBuilder.append("|");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        for (int i = 0; i < n * 2 - 1; i++) {
            if (i == 0 || i == n * 2 - 2) {
                stringBuilder.append("+");
            } else {
                stringBuilder.append("-");
            }
        }
        stringBuilder.append(System.lineSeparator());
        System.out.printf("%s", stringBuilder);
    }
}
