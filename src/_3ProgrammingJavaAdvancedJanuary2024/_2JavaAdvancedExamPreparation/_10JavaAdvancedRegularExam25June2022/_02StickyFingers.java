package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._10JavaAdvancedRegularExam25June2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        List<String> positionToMove = Arrays.stream(scanner.nextLine()
                        .split(","))
                .collect(Collectors.toList());
        char[][] matrix = fillMatrix(size, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playStickyFingers(positionToMove, matrix, row, col);
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][];
        for (int rows = 0; rows < size; rows++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[rows] = input;
        }
        return matrix;
    }

    private static int getRow(char[][] matrix) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'D') {
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
                if (matrix[i][j] == 'D') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playStickyFingers(List<String> positionToMove, char[][] matrix, int row, int col) {
        int stolenMoney = 0;
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
                System.out.printf("You cannot leave the town, there is police outside!%n");
                row = lastRow;
            }
            if (col < 0 || col > matrix[0].length - 1) {
                System.out.printf("You cannot leave the town, there is police outside!%n");
                col = lastCol;
            }
            char symbol = matrix[row][col];
            if (symbol == '$') {
                matrix[row][col] = '+';
                int robedMoney = col * row;
                stolenMoney += robedMoney;
                System.out.printf("You successfully stole %d$.%n", robedMoney);
            } else if (symbol == 'P') {
                matrix[row][col] = '#';
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                break;
            }
            matrix[row][col] = 'D';
            if (i == positionToMove.size() - 1) {
                System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
            }
        }
        printStickyFingers(matrix);
    }

    private static void printStickyFingers(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j] + " ");
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
