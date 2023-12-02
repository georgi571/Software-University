package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        printOutput(matrix);
    }
    private static int[][] readMatrix(Scanner scanner) {
        int[] n = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = n[0];
        int cols = n[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = elements;
        }
        return matrix;
    }
    private static void printOutput(int[][] matrix) {
        int totalSum = 0;
        int[][] winMatrix = new int[2][2];
        for (int rows = 0; rows < matrix.length - 1; rows++) {
            for (int cols = 0; cols < matrix[rows].length - 1; cols++) {
                int currentSum = matrix[rows][cols] + matrix[rows][cols + 1] + matrix[rows + 1][cols] + matrix[rows + 1][cols + 1];
                if (currentSum > totalSum) {
                    totalSum = currentSum;
                    winMatrix[0] = new int[] {matrix[rows][cols], matrix[rows][cols + 1]};
                    winMatrix[1] = new int[] {matrix[rows + 1][cols], matrix[rows + 1][cols + 1]};
                }
            }
        }
        for (int row = 0; row < winMatrix.length; row++) {
            for (int col = 0; col < winMatrix[row].length; col++) {
                System.out.printf("%d ", winMatrix[row][col]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%d%n", totalSum);
    }
}
