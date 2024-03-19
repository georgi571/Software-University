package _0Softuniada._2023;

import java.util.Scanner;

public class _02Rocket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = n + 5;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (i == m / 2) {
                stringBuilder.append("^");
            } else {
                stringBuilder.append("_");
            }
        }
        stringBuilder.append(System.lineSeparator());
        for (int i = 0; i < m; i++) {
            if (i == m / 2) {
                stringBuilder.append("|");
            } else if (i == (m / 2) - 1){
                stringBuilder.append("/");
            } else if (i == (m / 2) + 1){
                stringBuilder.append("\\");
            } else {
                stringBuilder.append("_");
            }
        }
        stringBuilder.append(System.lineSeparator());
        for (int i = 0; i < m; i++) {
            if (i == m / 2 || i == (m / 2) - 1 || i == (m / 2) + 1) {
                stringBuilder.append("|");
            } else if (i == (m / 2) - 2){
                stringBuilder.append("/");
            } else if (i == (m / 2) + 2){
                stringBuilder.append("\\");
            } else {
                stringBuilder.append("_");
            }
        }
        stringBuilder.append(System.lineSeparator());
        int count = 3;
        for (int i = (m / 2) - 2; i > 0; i--) {
            for (int j = 0; j < m; j++) {
                if (j == m / 2 || j == (m / 2) - 1 || j == (m / 2) + 1) {
                    stringBuilder.append("|");
                } else if (j == i - 1){
                    stringBuilder.append("/");
                } else if (j == (m / 2) + count){
                    stringBuilder.append("\\");
                } else if (j > i - 1 && j < (m / 2) - 1){
                    stringBuilder.append(".");
                } else if (j > (m / 2) + 1 && j < (m / 2) + count){
                    stringBuilder.append(".");
                } else {
                    stringBuilder.append("_");
                }
            }
            count++;
            stringBuilder.append(System.lineSeparator());
        }
        for (int i = 0; i < m; i++) {
            if (i == 0 || i == m - 1) {
                stringBuilder.append("_");
            } else if (i == m / 2 || i == (m / 2) - 1 || i == (m / 2) + 1) {
                stringBuilder.append("|");
            } else if (i == 1){
                stringBuilder.append("/");
            } else if (i == m - 2){
                stringBuilder.append("\\");
            } else {
                stringBuilder.append(".");
            }
        }
        stringBuilder.append(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == m / 2 || j == (m / 2) - 1 || j == (m / 2) + 1) {
                    stringBuilder.append("|");
                } else {
                    stringBuilder.append("_");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        for (int i = 0; i < m; i++) {
            if (i == m / 2 || i == (m / 2) - 1 || i == (m / 2) + 1) {
                stringBuilder.append("~");
            } else {
                stringBuilder.append("_");
            }
        }
        stringBuilder.append(System.lineSeparator());
        count = 1;
        for (int i = (m / 2); i > 2; i--) {
            for (int j = 0; j < m; j++) {
                if (j == m / 2) {
                    stringBuilder.append("!");
                } else if (j == i - 1 || j == i - 2){
                    stringBuilder.append("/");
                } else if (j == (m / 2) + count || j == (m / 2) + count + 1){
                    stringBuilder.append("\\");
                } else if (j > i - 1 && j < (m / 2)){
                    stringBuilder.append(".");
                } else if (j > (m / 2) && j < (m / 2) + count){
                    stringBuilder.append(".");
                } else {
                    stringBuilder.append("_");
                }
            }
            count++;
            stringBuilder.append(System.lineSeparator());
        }
        System.out.printf("%s", stringBuilder.toString());
    }
}
