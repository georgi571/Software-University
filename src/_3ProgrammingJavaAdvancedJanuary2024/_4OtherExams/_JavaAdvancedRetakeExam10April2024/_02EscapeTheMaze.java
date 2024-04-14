package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._JavaAdvancedRetakeExam10April2024;

import java.util.Scanner;

public class _02EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        char[][] matrix = fillMatrix(scanner);
        int rowP = getRow(matrix, 'P');
        int colP = getRowCol(matrix, 'P');
        playEscapeTheMaze(scanner, matrix, health, rowP, colP);
    }
    private static char[][] fillMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());
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
                    row = i;
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
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playEscapeTheMaze(Scanner scanner, char[][] matrix, int health, int row, int col) {
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
            if ((row < 0 || row > matrix.length - 1) || (col < 0 || col > matrix[0].length - 1)) {
                if (row < 0 || row > matrix.length - 1) {
                    row = lastRow;
                }
                if (col < 0 || col > matrix[0].length - 1) {
                    col = lastCol;
                }
            } else {
                char symbol = matrix[row][col];
                if (symbol == 'M') {
                    health -= 40;
                    if (health > 0) {
                        matrix[row][col] = '-';
                    } else {
                        health = 0;
                        System.out.printf("Player is dead. Maze over!%n");
                        break;
                    }
                } else if (symbol == 'H') {
                    health += 15;
                    if (health > 100) {
                        health = 100;
                    }
                    matrix[row][col] = '-';
                } else if (symbol == 'X') {
                    break;
                }
            }
            command = scanner.nextLine();
        }
        matrix[row][col] = 'P';
        if (health > 0) {
            System.out.printf("Player escaped the maze. Danger passed!%n");
        }
        System.out.printf("Player's health: %d units%n", health);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
