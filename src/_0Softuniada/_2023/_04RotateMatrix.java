package _0Softuniada._2023;

import java.util.Arrays;
import java.util.Scanner;

public class _04RotateMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        int[][] rotatedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            matrix[i] = row;
        }
        for (int i = 0; i < matrix.length; i++) {
            int col = 0;
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                rotatedMatrix[i][col] = matrix[j][i];
                col++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : rotatedMatrix) {
            for (int anInt : ints) {
                stringBuilder.append(String.format("%d ", anInt));
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.printf("%s", stringBuilder);
    }
}
