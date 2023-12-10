package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = getMatrix(scanner);
        printOutput(matrix, scanner);
    }
    private static char[][] getMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
    private static void printOutput(char[][] matrix, Scanner scanner) {
        char symbol = scanner.nextLine().charAt(0);
        int[] startPosition = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int startRow = startPosition[0];
        int startCol = startPosition[1];
        char oldSymbol = matrix[startRow][startCol];
        fill(matrix, startRow, startCol, symbol, oldSymbol);
        printMatrix(matrix);
    }
    private static void fill(char[][] matrix, int startRow, int startCol, char symbol, char oldSymbol) {
        if (matrix[startRow][startCol] != oldSymbol) {
            return;
        }
        matrix[startRow][startCol] = symbol;
        if (startRow + 1 < matrix.length) {
            fill(matrix, startRow + 1, startCol, symbol, oldSymbol);
        }
        if (startRow - 1 >= 0) {
            fill(matrix, startRow - 1, startCol, symbol, oldSymbol);
        }
        if (startCol + 1 < matrix[startRow].length) {
            fill(matrix, startRow, startCol + 1, symbol, oldSymbol);
        }
        if (startCol - 1 >= 0) {
            fill(matrix, startRow, startCol - 1, symbol, oldSymbol);
        }
    }
    private static void printMatrix(char[][] liar) {
        for (int rows = 0; rows < liar.length; rows++) {
            for (int cols = 0; cols < liar[rows].length; cols++) {
                System.out.printf("%c", liar[rows][cols]);
            }
            System.out.printf("%n");
        }
    }
}
