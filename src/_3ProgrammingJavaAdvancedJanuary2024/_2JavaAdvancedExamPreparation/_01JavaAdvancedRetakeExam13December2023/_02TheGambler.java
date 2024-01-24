package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._01JavaAdvancedRetakeExam13December2023;

import java.util.Scanner;

public class _02TheGambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(n, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        int amount = 100;
        playgamble(scanner, matrix, row, col, amount);
    }
    private static char[][] fillMatrix(int n, Scanner scanner) {
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[i] = input;
        }
        return matrix;
    }
    private static int getRow(char[][] matrix) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'G') {
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
                if (matrix[i][j] == 'G') {
                    col= j;
                }
            }
        }
        return col;
    }
    private static void playgamble(Scanner scanner, char[][] matrix, int row, int col, int amount) {
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
            if (row < 0 || row > matrix.length - 1) {
                amount = 0;
                printGamble(amount, matrix);
                break;
            }
            if (col < 0 || col > matrix[0].length - 1) {
                amount = 0;
                printGamble(amount, matrix);
                break;
            }
            char symbol = matrix[row][col];
            if (symbol == 'W') {
                amount += 100;
            } else if (symbol == 'P') {
                amount -= 200;
            } else if (symbol == 'J') {
                amount += 100000;
                matrix[row][col] = 'G';
                printGamble(amount, matrix);
                break;
            }
            matrix[row][col] = 'G';
            if (amount < 0) {
                printGamble(amount, matrix);
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("end")) {
            printGamble(amount, matrix);
        }
    }
    private static void printGamble(int amount, char[][] matrix) {
        if (amount > 100000) {
            System.out.printf("You win the Jackpot!%n");
            System.out.printf("End of the game. Total amount: %d$%n", amount);
        } else {
            if (amount <= 0) {
                System.out.printf("Game over! You lost everything!%n");
            } else {
                System.out.printf("End of the game. Total amount: %d$%n", amount);
            }
        }
        if (amount > 0) {
            for (int i = 0; i < matrix.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < matrix[i].length; j++) {
                    stringBuilder.append(matrix[i][j]);
                }
                System.out.printf("%s%n",stringBuilder);
            }
        }
    }
}
