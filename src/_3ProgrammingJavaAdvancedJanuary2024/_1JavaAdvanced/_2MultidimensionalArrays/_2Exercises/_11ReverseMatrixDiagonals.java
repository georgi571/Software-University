package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = getMatrix(scanner);
        printOutput(matrix);
    }
    private static int[][] getMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = size[0];
        int col = size[1];
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
    private static void printOutput(int[][] matrix) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        while (rows >= 0){
            int currentRow = rows;
            int currentCol = cols;
            StringBuilder output = new StringBuilder();
            while (currentCol <= matrix[0].length - 1 && currentRow >= 0) {
                int current = matrix[currentRow][currentCol];
                String currentOutput = current + " ";
                output.append(currentOutput);
                if (currentCol < matrix[currentRow].length) {
                    currentCol++;
                    currentRow--;
                }
            }
            if (cols == 0) {
                rows--;
            } else {
                cols--;
            }
            System.out.printf("%s%n",output);
        }
    }
}
