package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.Scanner;

public class _01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(",\\s+");
        int number = Integer.parseInt(command[0]);
        String letter = command[1];
        int[][] matrix = makeMatrixA(number, letter);
        printMatrix(matrix);
    }
    private static int[][] makeMatrixA(int number, String letter) {
        int num = 1;
        int[][] matrix = new int[number][number];
        for (int col = 0; col < number; col++) {
            if (letter.equals("A")) {
                for (int row = 0; row < number; row++) {
                    matrix[row][col] = num;
                    num++;
                }
            } else if (letter.equals("B")) {
                if ((col + 1) % 2 == 1) {
                    for (int row = 0; row < number; row++) {
                        matrix[row][col] = num;
                        num++;
                    }
                } else {
                    for (int row = number - 1; row >= 0; row--) {
                        matrix[row][col] = num;
                        num++;
                    }
                }
            }
        }
        return matrix;
    }
    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ",matrix[row][col]);
            }
            System.out.printf("%n");
        }
    }
}
