package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._09JavaAdvancedRetakeExam18August2022;

import java.util.Arrays;
import java.util.Scanner;

public class _02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playTreasureHunt(scanner, matrix, row, col);
    }

    private static char[][] fillMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = size[0];
        int m = size[1];
        char[][] matrix = new char[n][m];
        for (int rows = 0; rows < n; rows++) {
            char[] input = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[rows] = input;
        }
        return matrix;
    }

    private static int getRow(char[][] matrix) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'Y') {
                    row = i;
                }
            }
        }
        return row;
    }

    private static int getRowCol(char[][] matrix) {
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'Y') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playTreasureHunt(Scanner scanner, char[][] matrix, int row, int col) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The right path is ");
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            int lastRow = row;
            int lastCol = col;
            if (command.equals("up")) {
                row--;
            } else if (command.equals("down")) {
                row++;
            } else if (command.equals("left")) {
                col--;
            } else if (command.equals("right")) {
                col++;
            }
            if ((row < 0 || row > matrix.length - 1) || (col < 0 || col > matrix[0].length - 1)) {
                if (row < 0 || row > matrix.length - 1) {
                    row = lastRow;
                }
                if (col < 0 || col > matrix[0].length - 1) {
                    col = lastCol;
                }
            } else {
                char symbol = matrix[row][col];
                if (symbol == 'T') {
                    row = lastRow;
                    col = lastCol;
                } else if (symbol == 'X') {
                    System.out.printf("I've found the treasure!%n");
                    stringBuilder.append(command);
                    System.out.printf("%s%n", stringBuilder);
                    break;
                } else {
                    stringBuilder.append(command + ", ");
                }
            }
            command = scanner.nextLine();
        }
        if (command.equals("Finish")) {
            System.out.printf("The map is fake!%n");
        }
    }
}
