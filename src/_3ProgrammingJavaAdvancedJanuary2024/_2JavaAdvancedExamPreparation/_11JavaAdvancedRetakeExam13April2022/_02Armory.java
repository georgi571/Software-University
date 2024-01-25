package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._11JavaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class _02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int row = getRow(matrix, 'A');
        int col = getRowCol(matrix, 'A');
        playArmory(scanner, matrix, row, col);
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

    private static void playArmory(Scanner scanner, char[][] matrix, int row, int col) {
        matrix[row][col] = '-';
        int gold = 0;
        while (true) {
            String command = scanner.nextLine();
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
                System.out.printf("I do not need more swords!%n");
                break;
            } else {
                char symbol = matrix[row][col];
                if (symbol == 'M') {
                    matrix[row][col] = '-';
                    int rowM = getRow(matrix, 'M');
                    int colM = getRowCol(matrix, 'M');
                    row = rowM;
                    col = colM;
                    matrix[row][col] = '-';
                } else if (Character.isDigit(symbol)) {
                    matrix[row][col] = '-';
                    int currentPrice = Integer.parseInt(String.valueOf(symbol));
                    gold += currentPrice;
                    if (gold >= 65) {
                        matrix[row][col] = 'A';
                        System.out.printf("Very nice swords, I will come back for more!%n");
                        break;
                    }
                }
            }
        }
        System.out.printf("The king paid %d gold coins.%n", gold);
        printArmory(matrix);
    }

    private static void printArmory(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
