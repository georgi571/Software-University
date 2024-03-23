package _0Softuniada._2021;

import java.util.Arrays;
import java.util.Scanner;

public class _4EasterSurprise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = size[0];
        int col = size[1];

        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            String line = scanner.nextLine();
            String[] symbols = line.split("\\s+");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = symbols[j].charAt(0);
            }
        }
        char symbolFound = scanner.nextLine().charAt(0);
        int[] size2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row2 = size2[0];
        int col2 = size2[1];
        char forChange = matrix[row2][col2];
        searchEggs(matrix, symbolFound, row2, col2, forChange);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    private static void searchEggs(char[][] matrix, char symbolFound, int row, int col, char forChange) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] != forChange) {
            return;
        }
        matrix[row][col] = symbolFound;
        searchEggs(matrix, symbolFound, row - 1, col, forChange);
        searchEggs(matrix, symbolFound, row + 1, col, forChange);
        searchEggs(matrix, symbolFound, row, col - 1, forChange);
        searchEggs(matrix, symbolFound, row, col + 1, forChange);
    }
}
