package _0Softuniada._2017;

import java.util.Scanner;

public class _02HalloweenPumpkin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n * 2 + 1; i++) {
            if (i == n - 1 || i == n + 1) {
                stringBuilder.append("_");
            } else if (i == n) {
                stringBuilder.append("/");
            } else {
                stringBuilder.append(".");
            }
        }
        stringBuilder.append(System.lineSeparator());
        for (int i = 0; i < n * 2 + 1; i++) {
            if (i == 0) {
                stringBuilder.append("/");
            } else if (i == n * 2) {
                stringBuilder.append("\\");
            } else if (i == n) {
                stringBuilder.append(",");
            } else if (i == n - 1 || i == n + 1) {
                stringBuilder.append("^");
            } else {
                stringBuilder.append(".");
            }
        }
        stringBuilder.append(System.lineSeparator());
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < n * 2 + 1; i++) {
            if (i == 0 || i == n * 2) {
                stringBuilder2.append("|");
            } else {
                stringBuilder2.append(".");
            }
        }
        stringBuilder2.append(System.lineSeparator());
        for (int i = 3; i < n; i++) {
            stringBuilder.append(stringBuilder2);
        }
        for (int i = 0; i < n * 2 + 1; i++) {
            if (i == 0) {
                stringBuilder.append("\\");
            } else if (i == n * 2) {
                stringBuilder.append("/");
            } else if (i == n) {
                stringBuilder.append("_");
            } else if (i == n - 1) {
                stringBuilder.append("\\");
            } else if (i == n + 1) {
                stringBuilder.append("/");
            } else {
                stringBuilder.append(".");
            }
        }
        stringBuilder.append(System.lineSeparator());
        System.out.printf("%s", stringBuilder);
    }
}
