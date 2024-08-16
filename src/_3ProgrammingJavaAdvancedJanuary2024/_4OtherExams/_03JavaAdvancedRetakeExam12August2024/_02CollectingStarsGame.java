package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._03JavaAdvancedRetakeExam12August2024;

import java.util.Scanner;

public class _02CollectingStarsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(n, scanner);
        int goal = 2;
        int row = getRow(matrix, 'P');
        int col = getRowCol(matrix, 'P');
        playCollectingStarsGame(scanner, matrix, row, col, goal);
    }

    private static char[][] fillMatrix(int n, Scanner scanner) {
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[i] = input;
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

    private static void playCollectingStarsGame(Scanner scanner, char[][] matrix, int row, int col, int goal) {
        while (goal > 0 && goal < 10) {
            matrix[row][col] = '.';
            String command = scanner.nextLine();
            int oldRow = row;
            int oldCol = col;
            if (command.equals("up")) {
                row--;
            } else if (command.equals("down")) {
                row++;
            } else if (command.equals("left")) {
                col--;
            } else if (command.equals("right")) {
                col++;
            }
            if (row < 0 || row > matrix.length - 1 || col < 0 || col > matrix.length - 1) {
                row = 0;
                col = 0;
            }
            char position = matrix[row][col];
            if (position == '*') {
                goal++;
            } else if (position == '#') {
                goal--;
                row = oldRow;
                col = oldCol;
            }
        }
        matrix[row][col] = 'P';
        if (goal == 10) {
            System.out.printf("You won! You have collected 10 stars.%n");
        } else {
            System.out.printf("Game over! You are out of any stars.%n");
        }
        System.out.printf("Your final position is [%d, %d]%n", row, col);
        printStarGame(matrix);
    }

    private static void printStarGame(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j] + " ");
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
