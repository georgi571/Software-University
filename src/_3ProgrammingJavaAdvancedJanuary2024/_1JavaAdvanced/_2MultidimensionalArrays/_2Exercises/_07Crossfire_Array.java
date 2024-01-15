package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _07Crossfire_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = getMatrix(scanner);
        int[][] newMatrix = getNewMatrix(scanner, matrix);
        printOutput(newMatrix);
    }
    private static int[][] getMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = size[0];
        int col = size[1];
        int number = 1;
        int[][] matrix = new int[row][col];
        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                matrix[rows][cols] = number;
                number++;
            }
        }
        return matrix;
    }
    private static int[][] getNewMatrix(Scanner scanner, int[][] matrix) {
        int matrixSize = matrix.length;
        String text = scanner.nextLine();
        int[][] newMatrix = new int[matrixSize][];
        while (!text.equals("Nuke it from orbit")) {
            int[] size = Arrays.stream(text.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = size[0];
            int col = size[1];
            int radius = size[2];
            int rowUp = row - radius;
            int rowDown = row + radius;
            int colLeft = col - radius;
            int colRight = col + radius;
            int rowCounter = -1;
            for (int rows = 0; rows < matrix.length; rows++) {
                List<Integer> newMatrixRow = new ArrayList<>();
                if (rows == row) {
                    for (int cols = 0; cols < matrix[rows].length; cols++) {
                        if (cols < colLeft || cols > colRight) {
                            newMatrixRow.add(matrix[rows][cols]);
                        }
                    }
                } else {
                    if (rows >= rowUp && rows <= rowDown) {
                        for (int cols = 0; cols < matrix[rows].length; cols++) {
                            if (cols != col) {
                                newMatrixRow.add(matrix[rows][cols]);
                            }
                        }
                    } else {
                        for (int i = 0; i < matrix[rows].length; i++) {
                            newMatrixRow.add(matrix[rows][i]);
                        }
                    }
                }
                if (newMatrixRow.size() > 0) {
                    rowCounter++;
                    int[] array = new int[newMatrixRow.size()];
                    for (int i = 0; i < newMatrixRow.size(); i++) {
                        array[i] = newMatrixRow.get(i);
                    }
                    newMatrix[rowCounter] = array;
                }
            }
            if (matrixSize - 1 > rowCounter) {
                int[][] changeMatrix = new int[rowCounter + 1][];
                int counter = 0;
                for (int i = 0; i < changeMatrix.length; i++) {
                    int[] array = new int[newMatrix[i].length];
                    for (int cols = 0; cols < newMatrix[i].length; cols++) {
                        array[cols] = newMatrix[i][cols];
                    }
                    changeMatrix[counter] = array;
                    counter++;
                }
                matrix = changeMatrix;
            } else {
                matrix = newMatrix;
            }
            text = scanner.nextLine();
        }
        return matrix;
    }
    private static void printOutput(int[][] matrix) {
        for (int[] ints : matrix) {
            StringBuilder result = new StringBuilder();
            for (int anInt : ints) {
                result.append(anInt).append(" ");
            }
            System.out.printf("%s%n", result);
        }
    }
}
