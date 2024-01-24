package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._04JavaAdvancedRetakeExam9August2023;

import java.util.Arrays;
import java.util.Scanner;

public class _02DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playDelivery(scanner, matrix, row, col);
    }
    private static char[][] fillMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = size[0];
        int m = size[1];
        char[][] matrix = new char[n][m];
        for (int rows = 0; rows < n; rows++) {
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

    private static void playDelivery(Scanner scanner, char[][] matrix, int row, int col) {
        int firstRow = row;
        int firstCol = col;
        while (true) {
            String command = scanner.nextLine();
            int lastRow = row;
            int lastCol = col;
            if (matrix[row][col] != 'R') {
                matrix[row][col] = '.';
            }
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
                matrix[firstRow][firstCol] = ' ';
                System.out.printf("The delivery is late. Order is canceled.%n");
                break;
            }
            if (col < 0 || col > matrix[0].length - 1) {
                matrix[firstRow][firstCol] = ' ';
                System.out.printf("The delivery is late. Order is canceled.%n");
                break;
            }
            char symbol = matrix[row][col];
            if (symbol == 'P') {
                matrix[row][col] = 'R';
                System.out.printf("Pizza is collected. 10 minutes for delivery.%n");
            } else if (symbol == 'A') {
                matrix[row][col] = 'P';
                matrix[firstCol][firstRow] = 'B';
                System.out.printf("Pizza is delivered on time! Next order...%n");
                break;
            } else if (symbol == '*') {
                row = lastRow;
                col = lastCol;
            }
        }
        printDelivery(matrix);
    }
    private static void printDelivery(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                stringBuilder.append(matrix[rows][cols]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
