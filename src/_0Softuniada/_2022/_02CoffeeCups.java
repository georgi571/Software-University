package _0Softuniada._2022;

import java.util.Scanner;

public class _02CoffeeCups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append(" ");
            }
            for (int j = 0; j < 3; j++) {
                stringBuilder.append("~ ");
            }
            stringBuilder.append(System.lineSeparator());
        }
        int size = 3 * n + 5;
        for (int i = 0; i < size; i++) {
            stringBuilder.append("=");
        }
        stringBuilder.append(" ").append(System.lineSeparator());
        int charNumber = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0 || j == size - 1 || j == size - (n + 1)) {
                    stringBuilder.append("|");
                    if (j == 0 && i != n / 2 - 1) {
                        stringBuilder.append("~");
                    }
                } else if (j > n && charNumber < name.length() && i == n / 2 - 1) {
                    stringBuilder.append(String.format("%c", Character.toUpperCase(name.charAt(charNumber))));
                    charNumber++;
                    if (charNumber == name.length()) {
                        stringBuilder.append("~");
                    }
                } else if (j < size - (n + 1)) {
                    stringBuilder.append("~");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        for (int i = 0; i < size; i++) {
            stringBuilder.append("=");
        }
        stringBuilder.append(" ").append(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < size; j++) {
                if (j == i) {
                    stringBuilder.append("\\");
                } else if (j == size - (n + i)) {
                    stringBuilder.append("/");
                } else if (j < i) {
                    stringBuilder.append(" ");
                } else if (j < size - (n + i)) {
                    stringBuilder.append("@");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        for (int i = 0; i < size; i++) {
            stringBuilder.append("-");
        }
        System.out.printf("%s", stringBuilder.toString());
    }
}
