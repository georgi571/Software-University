package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._05JavaAdvancedRetakeExam12April2023;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hazelnuts = 0;
        int size = Integer.parseInt(scanner.nextLine());
        List<String> positionToMove = Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .collect(Collectors.toList());
        char[][] matrix = fillMatrix(size, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playSquirrel(positionToMove, matrix, row, col, hazelnuts);
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
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

    private static void playSquirrel(List<String> positionToMove, char[][] matrix, int row, int col, int hazelnuts) {
        boolean isGameStop = false;
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
            if (row < 0 || row > matrix.length - 1) {
                System.out.printf("The squirrel is out of the field.%n");
                isGameStop = true;
                break;
            }
            if (col < 0 || col > matrix[0].length - 1) {
                System.out.printf("The squirrel is out of the field.%n");
                isGameStop = true;
                break;
            }
            char symbol = matrix[row][col];
            if (symbol == 't') {
                matrix[row][col] = '*';
                System.out.printf("Unfortunately, the squirrel stepped on a trap...%n");
                isGameStop = true;
                break;
            } else if (symbol == 'h') {
                matrix[row][col] = '*';
                hazelnuts++;
                if (hazelnuts == 3) {
                    matrix[row][col] = 's';
                    System.out.printf("Good job! You have collected all hazelnuts!%n");
                    break;
                }
            }
        }
        if (!isGameStop && hazelnuts < 3) {
            System.out.printf("There are more hazelnuts to collect.%n");
        }
        System.out.printf("Hazelnuts collected: %d%n", hazelnuts);
    }
}
