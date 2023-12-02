package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04SumMatrixElements {
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
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                totalSum += matrix[rows][cols];
            }
        }
        System.out.printf("%d%n", matrix.length);
        System.out.printf("%d%n", matrix[0].length);
        System.out.printf("%d%n", totalSum);
    }
}
