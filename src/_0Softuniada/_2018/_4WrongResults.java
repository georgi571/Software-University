package _0Softuniada._2018;

import java.util.Scanner;

public class _4WrongResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][][] matrix = new int[size][size][size];
        for (int layer = 0; layer < size; layer++) {
            String[] layerData = scanner.nextLine().split(" \\| ");
            for (int row = 0; row < size; row++) {
                String[] rowData = layerData[row].split("\\s+");
                for (int col = 0; col < size; col++) {
                    matrix[row][layer][col] = Integer.parseInt(rowData[col]);
                }
            }
        }
        String[] coordinates = scanner.nextLine().split("\\s+");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        int z = Integer.parseInt(coordinates[2]);
        replaceWrongValues(matrix, x, y, z);
    }

    private static void replaceWrongValues(int[][][] matrix, int x, int y, int z) {
        int replacedElement = matrix[x][y][z];
        int replacedElementsCount = 0;
        int size = matrix.length;
        int[][][] newMatrix = new int[size][size][size];
        for (int layer = 0; layer < size; layer++) {
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (matrix[layer][row][col] == replacedElement) {
                        int newValue = calculateNewValue(matrix, layer, row, col, replacedElement);
                        newMatrix[layer][row][col] = newValue;
                        replacedElementsCount++;
                    } else {
                        newMatrix[layer][row][col] = matrix[layer][row][col];
                    }
                }
            }
        }
        System.out.printf("Wrong values found and replaced: %d%n", replacedElementsCount);
        printMatrix(newMatrix);
    }

    private static int calculateNewValue(int[][][] matrix, int x, int y, int z, int replacedElement) {
        int sum = 0;
        int size = matrix.length;
        if (isValid(size, x,y - 1, z)) {
            if (matrix[x][y - 1][z] != replacedElement) {
                sum += matrix[x][y - 1][z];
            }
        }
        if (isValid(size, x, y + 1, z)) {
            if (matrix[x][y + 1][z] != replacedElement) {
                sum += matrix[x][y + 1][z];
            }
        }
        if (isValid(size, x, y, z - 1)) {
            if (matrix[x][y][z - 1] != replacedElement) {
                sum += matrix[x][y][z - 1];
            }
        }
        if (isValid(size, x, y, z + 1)) {
            if (matrix[x][y][z + 1] != replacedElement) {
                sum += matrix[x][y][z + 1];
            }
        }
        if (isValid(size, x - 1, y, z)) {
            if (matrix[x - 1][y][z] != replacedElement) {
                sum += matrix[x - 1][y][z];
            }
        }
        if (isValid(size, x + 1, y, z)) {
            if (matrix[x + 1][y][z] != replacedElement) {
                sum += matrix[x + 1][y][z];
            }
        }
        return sum;
    }

    private static boolean isValid(int size, int x, int y, int z) {
        if (x >= 0 && x < size && y >= 0 && y < size && z >= 0 && z < size) {
            return true;
        }
        return false;
    }

    private static void printMatrix(int[][][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = matrix.length;
        for (int layer = 0; layer < size; layer++) {
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    stringBuilder.append(String.format("%d ", matrix[layer][row][col]));
                }
                stringBuilder.append(System.lineSeparator());
            }
        }
        System.out.printf("%s", stringBuilder);
    }
}
