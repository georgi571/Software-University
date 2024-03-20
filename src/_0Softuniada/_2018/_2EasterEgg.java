package _0Softuniada._2018;

import java.util.Scanner;

public class _2EasterEgg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        int weight = n * 5;
        int height = n * 2 + 3;
        int counter = n;
        int number = n;
        int first = n * 2;
        int stars = 0;
        char[][] matrix = new char[n + 2][weight];
        for (int i = 0; i < n + 2; i++) {
            if (i == 0) {
                for (int j = 0; j < weight; j++) {
                    if (j < n * 2 || j > n * 3 - 1) {
                        matrix[i][j] = '.';
                    } else if (j >= n * 2 && j < n * 3) {
                        matrix[i][j] = '*';
                    }
                }
            } else if (i == height / 2) {
                int count = 0;
                first++;
                int lenght = (weight - 12) / 2 - first - 2;
                for (int j = 0; j < first; j++) {
                    matrix[i][count] = '.';
                    count++;
                }
                for (int j = 0; j < 2; j++) {
                    matrix[i][count] = '*';
                    count++;
                }
                for (int j = 0; j < lenght; j++) {
                    matrix[i][count] = '~';
                    count++;
                }
                String happy = "HAPPY EASTER";
                for (int j = 0; j < happy.length(); j++) {
                    char character = happy.charAt(j);
                    matrix[i][count] = character;
                    count++;
                }
                for (int j = 0; j < lenght; j++) {
                    matrix[i][count] = '~';
                    count++;
                }
                for (int j = 0; j < 2; j++) {
                    matrix[i][count] = '*';
                    count++;
                }
                for (int j = 0; j < first; j++) {
                    matrix[i][count] = '.';
                    count++;
                }
            } else if (counter > n / 2) {
                int count = 0;
                for (int j = 0; j < first; j++) {
                    matrix[i][count] = '.';
                    count++;
                }
                for (int j = 0; j < stars; j++) {
                    matrix[i][count] = '*';
                    count++;
                }
                for (int j = 0; j < number; j++) {
                    matrix[i][count] = '+';
                    count++;
                }
                for (int j = 0; j < stars; j++) {
                    if (i <= n / 2) {
                        matrix[i][count] = '*';
                    } else {
                        matrix[i][count] = '=';
                    }
                    count++;
                }
                for (int j = 0; j < first; j++) {
                    matrix[i][count] = '.';
                    count++;
                }
            } else if (counter > 0) {
                int count = 0;
                for (int j = 0; j < first; j++) {
                    matrix[i][count] = '.';
                    count++;
                }
                for (int j = 0; j < 2; j++) {
                    matrix[i][count] = '*';
                    count++;
                }
                for (int j = 0; j < number; j++) {
                    matrix[i][count] = '=';
                    count++;
                }
                for (int j = 0; j < 2; j++) {
                    matrix[i][count] = '*';
                    count++;
                }
                for (int j = 0; j < first; j++) {
                    matrix[i][count] = '.';
                    count++;
                }
            }
            if (i < height / 2) {
                if (i > 0) {
                    counter--;
                }
                if (counter == n / 2) {
                    int more = n - 4;
                    number += more;
                }
                if (counter > n / 2) {
                    number += 2;
                    first -= 2;
                    stars++;
                } else {
                    number += 2;
                    first--;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            stringBuilder.append(System.lineSeparator());
        }
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.printf("%s", stringBuilder);
    }
}
