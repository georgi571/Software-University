package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._16JavaAdvancedRegularExam26June2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        List<String> positionToMove = Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .collect(Collectors.toList());
        char[][] matrix = fillMatrix(size, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playPython(positionToMove, matrix, row, col);
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
                if (matrix[i][j] == 's') {
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
                if (matrix[i][j] == 's') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playPython(List<String> positionToMove, char[][] matrix, int row, int col) {
        int pytonLength = 1;
        for (int i = 0; i < positionToMove.size(); i++) {
            String command = positionToMove.get(i);
            matrix[row][col] = '*';
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
                if (row < 0) {
                    row = matrix.length - 1;
                }
                if (row > matrix.length - 1) {
                    row = 0;
                }
                if (col < 0) {
                    col = matrix[0].length - 1;
                }
                if (col > matrix[0].length - 1) {
                    col = 0;
                }
            }
            char symbol = matrix[row][col];
            if (symbol == 'f') {
                pytonLength++;
                matrix[row][col] = '*';
                int leftFood = checkMatrix(matrix);
                if (leftFood == 0) {
                    break;
                }
            } else if (symbol == 'e') {
                System.out.printf("You lose! Killed by an enemy!%n");
                return;
            }
        }
        int leftFood = checkMatrix(matrix);
        if (leftFood > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.%n",leftFood);
        } else {
            System.out.printf("You win! Final python length is %d%n", pytonLength);
        }
    }

    private static int checkMatrix(char[][] matrix) {
        int leftFood = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'f') {
                    leftFood++;
                }
            }
        }
        return leftFood;
    }
}
