package _0Softuniada._2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04StarsInTheCube {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        char[][][] matrix = fillMatrix(scanner, n);
        int[] array = new int[26];
        int size = 0;
        for (int layer = 1; layer < n - 1; layer++) {
            for (int row = 1; row < n - 1; row++) {
                for (int col = 1; col < n - 1; col++) {
                    char currentLetter = matrix[layer][row][col];
                    if (isStar(matrix, layer, row, col, currentLetter)) {
                        array[currentLetter - 'a']++;
                        size++;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(size).append(System.lineSeparator());
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                stringBuilder.append((char) (i + 'a')).append(" -> ").append(array[i]).append(System.lineSeparator());
            }
        }
        System.out.println(stringBuilder);
    }

    private static char[][][] fillMatrix(BufferedReader scanner, int n) throws IOException {
        char[][][] matrix = new char[n][n][n];
        for (int layer = 0; layer < n; layer++) {
            String[] rows = scanner.readLine().split(" \\| ");
            for (int row = 0; row < n; row++) {
                matrix[row][layer] = rows[row].replaceAll("\\s+", "").toCharArray();
            }
        }
        scanner.close();
        return matrix;
    }

    private static boolean isStar(char[][][] matrix, int layer, int row, int col, char letter) {
        if (matrix[layer][row - 1][col] != letter) {
            return false;
        }
        if (matrix[layer][row + 1][col] != letter) {
            return false;
        }
        if (matrix[layer][row][col - 1] != letter) {
            return false;
        }
        if (matrix[layer][row][col + 1] != letter) {
            return false;
        }
        if (matrix[layer - 1][row][col] != letter) {
            return false;
        }
        return matrix[layer + 1][row][col] == letter;
    }
}