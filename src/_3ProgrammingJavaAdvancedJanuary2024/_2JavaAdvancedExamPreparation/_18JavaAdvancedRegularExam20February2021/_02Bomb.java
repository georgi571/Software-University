package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._18JavaAdvancedRegularExam20February2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        List<String> positionToMove = Arrays.stream(scanner.nextLine()
                        .split(","))
                .collect(Collectors.toList());
        char[][] matrix = fillMatrix(size, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playBomb(positionToMove, matrix, row, col);
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

    private static void playBomb(List<String> positionToMove, char[][] matrix, int row, int col) {
        int findBomb = 0;
        for (int i = 0; i < positionToMove.size(); i++) {
            String command = positionToMove.get(i);
            int lastRow = row;
            int lastCol = col;
            matrix[row][col] = '+';
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
                row = lastRow;
            }
            if (col < 0 || col > matrix[0].length - 1) {
                col = lastCol;
            }
            char symbol = matrix[row][col];
            if (symbol == 'B') {
                System.out.printf("You found a bomb!%n");
                matrix[row][col] = '+';
                findBomb++;
                int leftBomb = checkMatrix(matrix);
                if (leftBomb == 0) {
                    System.out.printf("Congratulations! You found all bombs!%n");
                    return;
                }
            } else if (symbol == 'e') {
                int leftBomb = checkMatrix(matrix);
                System.out.printf("END! %d bombs left on the field%n", leftBomb);
                return;
            }
        }
        int leftBomb = checkMatrix(matrix);
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", leftBomb, row, col);
    }

    private static int checkMatrix(char[][] matrix) {
        int leftBomb = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    leftBomb++;
                }
            }
        }
        return leftBomb;
    }
}
