package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._17JavaAdvancedRetakeExam14April2021;

import java.util.Scanner;

public class _02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int rowS = getRow(matrix, 'S');
        int colS = getRowCol(matrix, 'S');
        playCookingJourney(scanner, matrix, rowS, colS);
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

    private static void playCookingJourney(Scanner scanner, char[][] matrix, int row, int col) {
        int collectedMoney = 0;
        while (true) {
            String command = scanner.nextLine();
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
                System.out.printf("Bad news! You are out of the pastry shop.%n");
                break;
            } else {
                char symbol = matrix[row][col];
                if (Character.isDigit(symbol)) {
                    int currentMoney = Integer.parseInt(String.valueOf(symbol));
                    collectedMoney += currentMoney;
                    if (collectedMoney >= 50) {
                        System.out.printf("Good news! You succeeded in collecting enough money!%n");
                        matrix[row][col] = 'S';
                        break;
                    }
                } else if (symbol == 'P') {
                    matrix[row][col] = '-';
                    int rowB = getRow(matrix, 'P');
                    int colB = getRowCol(matrix, 'P');
                    row = rowB;
                    col = colB;
                    matrix[row][col] = '-';
                }
            }
        }
        System.out.printf("Money: %d%n",collectedMoney);
        printCookingJourney(matrix);
    }

    private static void printCookingJourney(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
