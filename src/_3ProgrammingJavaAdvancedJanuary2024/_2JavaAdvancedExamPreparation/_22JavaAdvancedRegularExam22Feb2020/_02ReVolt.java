package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._22JavaAdvancedRegularExam22Feb2020;

import java.util.Scanner;

public class _02ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int turns = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(size, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playReVolt(scanner, matrix, row, col, turns);
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][];
        for (int rows = 0; rows < size; rows++) {
            char[] input = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[rows] = input;
        }
        return matrix;
    }

    private static int getRow(char[][] matrix) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'f') {
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
                if (matrix[i][j] == 'f') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playReVolt(Scanner scanner, char[][] matrix, int row, int col, int turns) {
        matrix[row][col] = '-';
        String command = scanner.nextLine();
        while (true) {
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
            if (row < 0) {
                row = matrix.length - 1;
            }
            if (row > matrix.length - 1) {
                row = 0;
            }
            if (col < 0) {
                col = matrix[0].length - 1;
            }
            if (col > matrix[0].length - 1) {
                col = 0;
            }
            char symbol = matrix[row][col];
            if (symbol == 'T') {
                matrix[row][col] = 'T';
                row = lastRow;
                col = lastCol;
                turns--;
                if (turns == 0) {
                    matrix[row][col] = 'f';
                    System.out.printf("Player lost!%n");
                    break;
                }
                command = scanner.nextLine();
            } else if (symbol == 'B') {
                matrix[row][col] = 'B';
                command = command;
            } else if (symbol == 'F') {
                matrix[row][col] = 'f';
                System.out.printf("Player won!%n");
                break;
            } else {
                turns--;
                if (turns == 0) {
                    matrix[row][col] = 'f';
                    System.out.printf("Player lost!%n");
                    break;
                }
                command = scanner.nextLine();
            }
        }
        printReVolt(matrix);
    }

    private static void printReVolt(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
