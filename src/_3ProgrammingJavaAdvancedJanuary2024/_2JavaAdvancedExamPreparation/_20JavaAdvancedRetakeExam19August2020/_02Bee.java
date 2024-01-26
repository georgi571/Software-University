package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._20JavaAdvancedRetakeExam19August2020;

import java.util.Scanner;

public class _02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playBee(scanner, matrix, row, col);
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

    private static int getRow(char[][] matrix) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
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
                if (matrix[i][j] == 'B') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playBee(Scanner scanner, char[][] matrix, int row, int col) {
        int flowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            matrix[row][col] = '.';
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
                System.out.printf("The bee got lost!%n");
                break;
            } else {
                char symbol = matrix[row][col];
                if (symbol == 'f') {
                    flowers++;
                    matrix[row][col] = 'B';
                    command = scanner.nextLine();
                } else if (symbol == 'O') {
                    matrix[row][col] = 'B';
                    command = command;
                } else {
                    matrix[row][col] = 'B';
                    command = scanner.nextLine();
                }
            }
        }
        if (flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 - flowers));
        }
        printBee(matrix);
    }

    private static void printBee(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
