package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._21JavaAdvancedRegularExam28June2020;

import java.util.Scanner;

public class _02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int rowS = getRow(matrix, 'S');
        int colS = getRowCol(matrix, 'S');
        playSnake(scanner, matrix, rowS, colS);
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

    private static void playSnake(Scanner scanner, char[][] matrix, int row, int col) {
        int foodEaten = 0;
        while (true) {
            String command = scanner.nextLine();
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
                System.out.printf("Game over!%n");
                break;
            } else {
                char symbol = matrix[row][col];
                if (symbol == '*') {
                    foodEaten++;
                    if (foodEaten >= 10) {
                        System.out.printf("You won! You fed the snake.%n");
                        matrix[row][col] = 'S';
                        break;
                    }
                } else if (symbol == 'B') {
                    matrix[row][col] = '.';
                    int rowB = getRow(matrix, 'B');
                    int colB = getRowCol(matrix, 'B');
                    row = rowB;
                    col = colB;
                    matrix[row][col] = 'S';
                }
            }
        }

        System.out.printf("Food eaten: %d%n", foodEaten);
        printSnake(matrix);
    }

    private static void printSnake(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
