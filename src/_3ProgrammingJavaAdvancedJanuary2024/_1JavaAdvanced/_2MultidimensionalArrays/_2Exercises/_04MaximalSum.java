package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        printOutput(matrix);
        System.out.printf("%n");
    }
    private static int[][] readMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = array;
        }
        return matrix;
    }
    private static void printOutput(int[][] matrix) {
        int sum = 0;
        int[][] rectangleMatrix = new int[3][3];
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int row1 = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2];
                int row2 = matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2];
                int row3 = matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                int currentSum = row1 + row2 + row3;
                if (currentSum > sum) {
                    sum = currentSum;
                    for (int i = 0; i < rectangleMatrix.length; i++) {
                        int[] array = new int[3];
                        array[0] = matrix[row + i][col];
                        array[1] = matrix[row + i][col + 1];
                        array[2] = matrix[row + i][col + 2];
                        rectangleMatrix[i] = array;
                    }
                }
            }
        }
        System.out.printf("Sum = %d%n", sum);
        for (int row = 0; row < rectangleMatrix.length; row++) {
            for (int col = 0; col < rectangleMatrix[row].length; col++) {
                System.out.printf("%d ",rectangleMatrix[row][col]);
            }
            System.out.printf("%n");
        }
    }
}
