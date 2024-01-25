package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._07JavaAdvancedRetakeExam14December2022;

import java.util.Scanner;

public class _02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playNavyBattle(scanner, matrix, row, col);
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
                if (matrix[i][j] == 'S') {
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
                if (matrix[i][j] == 'S') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playNavyBattle(Scanner scanner, char[][] matrix, int row, int col) {
        int cruisers = 0;
        int mines = 0;
        matrix[row][col] = '-';
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                row--;
            } else if (command.equals("down")) {
                row++;
            } else if (command.equals("left")) {
                col--;
            } else if (command.equals("right")) {
                col++;
            }
            char symbol = matrix[row][col];
            if (symbol == '*') {
                mines++;
                if (mines == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, col);
                    matrix[row][col] = 'S';
                    break;
                }
            } else if (symbol == 'C') {
                cruisers++;
                if (cruisers == 3) {
                    System.out.printf("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!%n");
                    matrix[row][col] = 'S';
                    break;
                }
            }
            matrix[row][col] = '-';
        }
        printNavyBattle(matrix);
    }

    private static void printNavyBattle(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
