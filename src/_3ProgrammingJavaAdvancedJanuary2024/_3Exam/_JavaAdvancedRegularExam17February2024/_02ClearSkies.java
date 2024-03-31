package _3ProgrammingJavaAdvancedJanuary2024._3Exam._JavaAdvancedRegularExam17February2024;

import java.util.Scanner;

public class _02ClearSkies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(n, scanner);
        int row = getRow(matrix, 'J');
        int col = getRowCol(matrix, 'J');
        int armour = 300;
        playClearSkies(scanner, matrix, row, col, armour);
    }

    private static char[][] fillMatrix(int n, Scanner scanner) {
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();
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

    private static void playClearSkies(Scanner scanner, char[][] matrix, int row, int col, int armour) {
        matrix[row][col] = '-';
        while (true) {
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
            char position = matrix[row][col];
            if (position == 'E') {
                int enemy = countEnemy(matrix);
                if (enemy == 1) {
                    matrix[row][col] = '-';
                }
                if (enemy > 1) {
                    armour -= 100;
                    if (armour == 0) {
                        matrix[row][col] = 'J';
                        System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n", row, col);
                        break;
                    } else {
                        matrix[row][col] = '-';
                    }
                }
                if (enemy - 1 == 0) {
                    matrix[row][col] = 'J';
                    System.out.printf("Mission accomplished, you neutralized the aerial threat!%n");
                    break;
                }
            } else if (position == 'R') {
                if (armour == 300) {
                    matrix[row][col] = '-';
                } else {
                    armour = 300;
                    matrix[row][col] = '-';
                }
            }
        }
        printClearSkies(matrix);
    }

    private static int countEnemy(char[][] matrix) {
        int counter = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == 'E') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void printClearSkies(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
