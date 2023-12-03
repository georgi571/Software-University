package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int[][] newMatrix = makeNewMatrix(matrix, scanner);
        printNewMatrix(newMatrix);
    }
    private static int[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];
        for (int row = 0; row < n; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = elements;
        }
        return matrix;
    }
    private static int[][] makeNewMatrix(int[][] matrix, Scanner scanner) {
        int[][] newMatrix = new int[matrix.length][];
        int[] index = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = index[0];
        int col = index[1];
        int number = matrix[row][col];
        for (int rows = 0; rows < matrix.length ; rows++) {
            int[] array = new int[matrix[rows].length];
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == number) {
                    int leftNumber = 0;
                    int rightNumber = 0;
                    int upNumber = 0;
                    int downNumber = 0;
                    int currentNumber;
                    if (cols > 0 && cols <= matrix[rows].length) {
                        currentNumber = matrix[rows][cols - 1];
                        if (currentNumber != number) {
                            leftNumber = currentNumber;
                        }
                    }
                    if (cols < matrix[rows].length - 1) {
                        currentNumber = matrix[rows][cols + 1];
                        if (currentNumber != number) {
                            rightNumber = currentNumber;
                        }
                    }
                    if (rows > 0) {
                        currentNumber = matrix[rows - 1][cols];
                        if (currentNumber != number) {
                            upNumber = currentNumber;
                        }
                    }
                    if (rows < matrix.length - 1) {
                        currentNumber = matrix[rows + 1][cols];
                        if (currentNumber != number) {
                            downNumber = currentNumber;
                        }
                    }
                    array[cols] = leftNumber + rightNumber + upNumber + downNumber;
                } else {
                    array[cols] = matrix[rows][cols];
                }
            }
            newMatrix[rows] = array;
        }
        return newMatrix;
    }
    private static void printNewMatrix(int[][] newMatrix) {
        for (int rows = 0; rows < newMatrix.length; rows++) {
            for (int cols = 0; cols < newMatrix[rows].length; cols++) {
                System.out.printf("%d ", newMatrix[rows][cols]);
            }
            System.out.printf("%n");
        }
    }
}
