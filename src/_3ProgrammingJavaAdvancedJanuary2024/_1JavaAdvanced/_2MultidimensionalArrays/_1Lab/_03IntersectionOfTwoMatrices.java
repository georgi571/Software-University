package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._1Lab;

import java.util.Scanner;

public class _03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readMatrix(scanner, rows, cols);
        char[][] thirdMatrix = madeThirdMatrix(firstMatrix, secondMatrix, rows, cols);
        printThirdMatrix(thirdMatrix);
    }
    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] array = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[row] = array;
        }
        return matrix;
    }
    private static char[][] madeThirdMatrix(char[][] firstMatrix, char[][] secondMatrix, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < firstMatrix.length; row++) {
            char[] firstArray = firstMatrix[row];
            char[] secondArray = secondMatrix[row];
            char[] newArray = new char[cols];
            for (int col = 0; col < firstArray.length; col++) {
                char firstArraySymbol = firstArray[col];
                char secondArraySymbol = secondArray[col];
                if (firstArraySymbol == secondArraySymbol) {
                    newArray[col] = firstArraySymbol;
                } else {
                    newArray[col] = '*';
                }
            }
            matrix[row] = newArray;
        }
        return matrix;
    }
    private static void printThirdMatrix(char[][] thirdMatrix) {
        for (int row = 0; row < thirdMatrix.length; row++) {
            for (int col = 0; col < thirdMatrix[row].length; col++) {
                System.out.printf("%c ", thirdMatrix[row][col]);
            }
            System.out.printf("%n");
        }
    }
}
