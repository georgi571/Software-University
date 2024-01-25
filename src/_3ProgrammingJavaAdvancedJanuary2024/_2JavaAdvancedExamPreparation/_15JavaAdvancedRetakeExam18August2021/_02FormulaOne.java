package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._15JavaAdvancedRetakeExam18August2021;

import java.util.Scanner;

public class _02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(size, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playFormulaOne(scanner, matrix, row, col, numberOfCommands);
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

    private static void playFormulaOne(Scanner scanner, char[][] matrix, int row, int col, int numberOfCommands) {
        matrix[row][col] = '.';
        String command = scanner.nextLine();
        for (int i = 0; i < numberOfCommands; i++) {
            int oldRow = row;
            int oldCol = col;
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
                if (i < numberOfCommands - 1) {
                    command = scanner.nextLine();
                }
            } else {
                char symbol = matrix[row][col];
                if (symbol == 'T') {
                    row = oldRow;
                    col = oldCol;
                    command = scanner.nextLine();
                } else if (symbol == 'B') {
                    command = command;
                    i--;
                } else if (symbol == 'F') {
                    matrix[row][col] = 'P';
                    System.out.printf("Well done, the player won first place!%n");
                    printFormulaOne(matrix);
                    return;
                } else {
                    if (i < numberOfCommands - 1) {
                        command = scanner.nextLine();
                    }
                }
            }
        }
        matrix[row][col] = 'P';
        System.out.printf("Oh no, the player got lost on the track!%n");
        printFormulaOne(matrix);
    }

    private static void printFormulaOne(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
