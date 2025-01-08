package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._05JavaAdvancedRetakeExam12December2024;

import java.util.Scanner;

public class _02SpaceMission {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(n, scanner);
        int row = getRow(matrix, 'S');
        int col = getRowCol(matrix, 'S');
        int fuel = 100;
        playSpaceMission(scanner, matrix, row, col, fuel);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char aChar : chars) {
                stringBuilder.append(aChar).append(" ");
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }

    private static void playSpaceMission(Scanner scanner, char[][] matrix, int row, int col, int fuel) {
        matrix[row][col] = '.';
        int lastRow = row;
        int lastCol = col;
        while (true) {
            fuel -= 5;
            if (fuel < 0) {
                System.out.printf("Mission failed! The spaceship was stranded in space.%n");
                matrix[lastRow][lastCol] = 'S';
                break;
            }

            String command = scanner.nextLine();
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
                System.out.printf("Mission failed! The spaceship was lost in space.%n");
                matrix[lastRow][lastCol] = 'S';
                break;
            } else {
                lastRow = row;
                lastCol = col;
                char position = matrix[row][col];
                if (position == 'R') {
                    fuel += 10;
                    if (fuel > 100) {
                        fuel = 100;
                    }
                } else if (position == 'M') {
                    fuel -= 5;
                    matrix[row][col] = '.';
                } else if (position == 'P') {
                    System.out.printf("Mission accomplished! The spaceship reached Planet B with %d resources left.%n", fuel);
                    break;
                }
            }
        }
        printMatrix(matrix);
    }

    private static char[][] fillMatrix(int n, Scanner scanner) {
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = input;
        }
        return matrix;
    }

    private static int getRow(char[][] matrix, char symbol) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == symbol) {
                    row = i;
                    break;
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
                    break;
                }
            }
        }
        return col;
    }
}
