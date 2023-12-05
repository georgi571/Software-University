package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        printOutput(matrix);
    }
    private static int[][] readMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int rows = 0; rows < size; rows++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            matrix[rows] = array;
        }
        return matrix;
    }
    private static void printOutput(int[][] matrix) {
        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int row = 0; row < matrix.length; row++) {
            diagonal1 += matrix[row][row];
            diagonal2 += matrix[matrix.length - row -1][row];
        }
        int different = Math.abs(diagonal1 - diagonal2);
        System.out.printf("%d%n",different);
    }
}
