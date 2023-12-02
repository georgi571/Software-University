package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        printOutput(matrix);
    }
    private static int[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = elements;
        }
        return matrix;
    }
    private static void printOutput(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            System.out.printf("%d ", matrix[rows][rows]);
        }
        System.out.printf("%n");
        int col = 0;
        for (int rows = matrix.length - 1; rows >= 0; rows--) {
            System.out.printf("%d ", matrix[rows][col]);
            col++;
        }
        System.out.printf("%n");
    }
}
