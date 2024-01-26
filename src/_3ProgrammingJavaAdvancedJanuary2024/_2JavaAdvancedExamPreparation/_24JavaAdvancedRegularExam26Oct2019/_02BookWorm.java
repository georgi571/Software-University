package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._24JavaAdvancedRegularExam26Oct2019;

import java.util.Scanner;

public class _02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(size, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playBookWorm(scanner, matrix, row, col, firstWord);
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
                if (matrix[i][j] == 'P') {
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
                if (matrix[i][j] == 'P') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playBookWorm(Scanner scanner, char[][] matrix, int row, int col, String firstWord) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstWord);
        matrix[row][col] = '-';
        String command = scanner.nextLine();
        while (!command.equals("end")) {
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
                row = lastRow;
                col = lastCol;
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
            char symbol = matrix[row][col];
            if (symbol != '-') {
                matrix[row][col] = '-';
                stringBuilder.append(symbol);
            }
            command = scanner.nextLine();
        }
        matrix[row][col] = 'P';
        System.out.printf("%s%n", stringBuilder);
        printBookWorm(matrix);
    }

    private static void printBookWorm(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
