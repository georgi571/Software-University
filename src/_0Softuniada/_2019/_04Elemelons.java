package _0Softuniada._2019;

import java.util.Scanner;

public class _04Elemelons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][][] matrix = new char[n][n][n];
        for (int layer = 0; layer < n; layer++) {
            String[] matrixRow = scanner.nextLine().split(" \\| ");
            for (int row = 0; row < n; row++) {
                matrix[row][layer] = matrixRow[row].replaceAll("\\s+", "").toCharArray();
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Melolemonmelon")) {
            String[] coordinates = command.split("\\s+");
            int layer = Integer.parseInt(coordinates[0]);
            int row = Integer.parseInt(coordinates[1]);
            int col = Integer.parseInt(coordinates[2]);
            matrix[layer][row][col] = '0';
            updateNeighbors(matrix, n, layer, row, col);
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }
    private static void updateNeighbors(char[][][] matrix, int n, int layer, int row, int col) {
        char[][][] oldMatrix = new char[n][n][n];
        oldMatrix[layer][row][col] = '0';
        int[] dLayer = {0, 0, 0, 0, 1, -1};
        int[] dRow = {0, 0, 1, -1, 0, 0};
        int[] dCol = {1, -1, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            int newLayer = layer + dLayer[i];
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (isValid(newLayer, newRow, newCol, n) && matrix[newLayer][newRow][newCol] != '0') {
                oldMatrix[newLayer][newRow][newCol] = matrix[newLayer][newRow][newCol];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < matrix[i][j].length; k++) {
                    if (oldMatrix[i][j][k] != matrix[i][j][k]) {
                        oldMatrix[i][j][k] = getNextMelon(matrix[i][j][k]);
                        matrix[i][j][k] = oldMatrix[i][j][k];
                    }
                }
            }
        }
    }
    private static boolean isValid(int layer, int row, int col, int n) {
        return layer >= 0 && layer < n && row >= 0 && row < n && col >= 0 && col < n;
    }
    private static char getNextMelon(char melon) {
        if (melon == 'W') {
            return 'E';
        } else if (melon == 'E') {
            return 'F';
        } else if (melon == 'F') {
            return 'A';
        } else if (melon == 'A') {
            return 'W';
        } else {
            return melon;
        }
    }
    private static void printMatrix(char[][][] matrix) {
        for (int layer = 0; layer < matrix.length; layer++) {
            for (int row = 0; row < matrix[layer].length; row++) {
                for (int col = 0; col < matrix[layer][row].length; col++) {
                    System.out.printf("%c ", matrix[row][layer][col]);
                }
                if (row < matrix[layer].length - 1) {
                    System.out.printf("| ");
                }
            }
            System.out.printf("%n");
        }
    }
}

