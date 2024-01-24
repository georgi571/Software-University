package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._02JavaAdvancedRegularExam21October2023;

import java.util.Scanner;

public class _02FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(n, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playFishing(scanner, matrix, row, col);
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

    private static void playFishing(Scanner scanner, char[][] matrix, int row, int col) {
        int amount = 0;
        String command = scanner.nextLine();
        while (!command.equals("collect the nets")) {
            matrix[row][col] = '-';
            if (command.equals("up")) {
                row--;
                if (row < 0) {
                    row = matrix.length - 1;
                }
            } else if (command.equals("down")) {
                row++;
                if (row > matrix.length - 1) {
                    row = 0;
                }
            } else if (command.equals("left")) {
                col--;
                if (col < 0) {
                    col = matrix[row].length - 1;
                }
            } else if (command.equals("right")) {
                col++;
                if (col > matrix[row].length - 1) {
                    col = 0;
                }
            }
            char symbol = matrix[row][col];
            if (symbol == 'W') {
                amount = 0;
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n", row, col);
                break;
            } else if (symbol != '-') {
                amount += Integer.parseInt(String.valueOf(symbol));
            }
            matrix[row][col] = 'S';
            command = scanner.nextLine();
        }
        if (command.equals("collect the nets")) {
            printFishing(amount, matrix);
        }
    }

    private static void printFishing(int amount, char[][] matrix) {
        if (amount >= 20) {
            System.out.printf("Success! You managed to reach the quota!%n");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", (20 - amount));
        }
        if (amount > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", amount);
        }
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
