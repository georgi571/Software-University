package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = readMatrix(scanner);
        printOutput(matrix);
    }
    private static char[][] readMatrix(Scanner scanner) {
        char[][] matrix = new char[8][8];
        for (int row = 0; row < 8; row++) {
            char[] elements = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[row] = elements;
        }
        return matrix;
    }
    private static void printOutput(char[][] matrix) {
        for (int rows = 0; rows < matrix.length ; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == 'q') {
                    int qCounter = 0;
                    for (int rowCounter = 0; rowCounter < matrix.length; rowCounter++) {
                        if (rowCounter != cols) {
                            if (matrix[rows][rowCounter] == 'q') {
                                qCounter++;
                            }
                        }
                    }
                    for (int colCounter = 0; colCounter < matrix.length; colCounter++) {
                        if (colCounter != rows) {
                            if (matrix[colCounter][cols] == 'q') {
                                qCounter++;
                            }
                        }
                    }
                    int leftCol = cols - rows;
                    if (leftCol < 0) {
                        leftCol = 0;
                    }
                    int leftRow = rows - cols;
                    if (leftRow < 0) {
                        leftRow = 0;
                    }
                    for (int leftDiagonal = leftRow; leftDiagonal < matrix.length && leftCol < 8; leftDiagonal++) {
                        if (leftDiagonal != rows && leftCol != cols) {
                            if (matrix[leftDiagonal][leftCol] == 'q') {
                                qCounter++;
                            }
                        }
                        leftCol++;
                    }
                    int rightCol = rows + cols;
                    if (rightCol > 7) {
                        rightCol = 7;
                    }
                    int rightRow = rows - (7 - cols);
                    if (rightRow < 0) {
                        rightRow = 0;
                    }
                    for (int rightDiagonal = rightRow; rightDiagonal < matrix.length && rightCol >= 0; rightDiagonal++) {
                        if (rightDiagonal != rows && rightCol != cols) {
                            if (matrix[rightDiagonal][rightCol] == 'q') {
                                qCounter++;
                            }
                        }
                        rightCol--;
                    }
                    if (qCounter == 0) {
                        System.out.printf("%d %d %n", rows, cols);
                    }
                }
            }
        }
    }
}
