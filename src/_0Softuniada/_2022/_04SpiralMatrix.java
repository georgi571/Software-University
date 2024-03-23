package _0Softuniada._2022;

import java.util.Arrays;
import java.util.Scanner;

public class _04SpiralMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = row;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                if (matrix[i][j] > 0) {
                    stringBuilder.append(String.format("%d ", matrix[i][j]));
                    matrix[i][j] = 0;
                }
            }
            int col = m - 1 - i;
            for (int j = 0; j < n; j++) {
                if (col >= 0 && matrix[j][col] > 0) {
                    stringBuilder.append(String.format("%d ", matrix[j][col]));
                    matrix[j][col] = 0;
                }
            }
            int row = n - i - 1;
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[row][j] > 0) {
                    stringBuilder.append(String.format("%d ", matrix[row][j]));
                    matrix[row][j] = 0;
                }

            }
            for (int j = n - 1; j >= 0; j--) {
                if (i < m && matrix[j][i] > 0) {
                    stringBuilder.append(String.format("%d ", matrix[j][i]));
                    matrix[j][i] = 0;
                }
            }
        }
        System.out.printf("%s", stringBuilder);
    }
}
