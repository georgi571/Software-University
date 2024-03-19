package _0Softuniada._2023;

import java.util.Scanner;

public class _01RowInPascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            int[] row = new int[i + 1];
            if (i == 0) {
                row[0] = 1;
                matrix[0] = row;
            } else if (i == 1) {
                row[0] = 1;
                row[1] = 1;
                matrix[1] = row;
            } else {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) {
                        row[0] = 1;
                    } else if (j == i) {
                        row[j] = 1;
                    } else {
                        row[j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
                    }
                }
                matrix[i] = row;
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < matrix[n].length; j++) {
            stringBuilder.append(matrix[n][j] + " ");
        }
        System.out.printf("%s%n", stringBuilder);
    }
}
