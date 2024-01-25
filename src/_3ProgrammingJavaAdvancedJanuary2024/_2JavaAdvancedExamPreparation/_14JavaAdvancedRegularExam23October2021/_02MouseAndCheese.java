package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._14JavaAdvancedRegularExam23October2021;

import java.util.Scanner;

public class _02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playMouseAndCheese(scanner, matrix, row, col);


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
                if (matrix[i][j] == 'M') {
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
                if (matrix[i][j] == 'M') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playMouseAndCheese(Scanner scanner, char[][] matrix, int row, int col) {
        int eatenCheese = 0;
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            matrix[row][col] = '-';
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
                System.out.printf("Where is the mouse?%n");
                break;
            } else {
                char symbol = matrix[row][col];
                if (symbol == 'c') {
                    eatenCheese++;
                    matrix[row][col] = 'M';
                    command = scanner.nextLine();
                } else if (symbol == 'B') {
                    matrix[row][col] = 'M';
                    command = command;
                } else {
                    matrix[row][col] = 'M';
                    command = scanner.nextLine();
                }
            }
        }
        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", (5 - eatenCheese));
        }
        printMouseAndCheese(matrix);
    }

    private static void printMouseAndCheese(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
