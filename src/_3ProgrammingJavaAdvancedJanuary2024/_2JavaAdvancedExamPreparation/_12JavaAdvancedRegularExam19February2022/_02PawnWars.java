package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._12JavaAdvancedRegularExam19February2022;

import java.util.Scanner;

public class _02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int rowW = getRow(matrix, 'w');
        int colW = getRowCol(matrix, 'w');
        int rowB = getRow(matrix, 'b');
        int colB = getRowCol(matrix, 'b');
        playPawnWars(matrix, rowW, colW, rowB, colB);
    }

    private static char[][] fillMatrix(Scanner scanner) {
        int size = 8;
        char[][] matrix = new char[size][];
        for (int rows = 0; rows < size; rows++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[rows] = input;
        }
        return matrix;
    }

    private static int getRow(char[][] matrix, char symbol) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == symbol) {
                    row = 8 - i;
                }
            }
        }
        return row;
    }

    private static int getRowCol(char[][] matrix, char symbol) {
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == symbol) {
                    col = j + 1;
                }
            }
        }
        return col;
    }

    private static void playPawnWars(char[][] matrix, int rowW, int colW, int rowB, int colB) {
        char charW = (char) ('a' + colW - 1);
        char charB = (char) ('a' + colB - 1);
        while (true) {
            if (rowB == rowW + 1 && (colW == colB + 1 || colW == colB - 1)) {
                System.out.printf("Game over! White capture on %c%d.%n", charB, rowB);
                break;
            } else {
                rowW++;
                if (rowW == 8) {
                    System.out.printf("Game over! White pawn is promoted to a queen at %c8.%n", charW);
                    break;
                }
            }
            if (rowW == rowB - 1 && (colW == colB + 1 || colW == colB - 1)) {
                System.out.printf("Game over! Black capture on %c%d.%n", charW, rowW);
                break;
            } else {
                rowB--;
                if (rowB == 1) {
                    System.out.printf("Game over! Black pawn is promoted to a queen at %c1.%n", charB);
                    break;
                }
            }
        }
    }
}
