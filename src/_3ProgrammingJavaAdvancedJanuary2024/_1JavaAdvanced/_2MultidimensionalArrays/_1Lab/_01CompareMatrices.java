package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);
        boolean isMatrixAreEqual = compareMatrix(firstMatrix, secondMatrix);
        String output = isMatrixAreEqual ? "equal" : "not equal";
        System.out.printf("%s%n", output);
    }
    private static int[][] readMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows= size[0];
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
    private static boolean compareMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int rows = 0; rows < firstMatrix.length; rows++) {
            int[] firstArray = firstMatrix[rows];
            int[] secondArray = secondMatrix[rows];
            if (firstArray.length != secondArray.length) {
                return false;
            }
            for (int cols = 0; cols < firstArray.length; cols++) {
                int firstElement = firstArray[cols];
                int secondElement = secondArray[cols];
                if (firstElement != secondElement) {
                    return false;
                }
            }
        }
        return true;
    }
}
