package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._03JavaAdvancedRegularExam17June2023;

import java.util.Arrays;
import java.util.Scanner;

public class _02MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = fillMatrix(scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playMouse(scanner, matrix, row, col);
    }

    private static char[][] fillMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split(","))
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
                if (matrix[i][j] == 'M') {
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
                if (matrix[i][j] == 'M') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playMouse(Scanner scanner, char[][] matrix, int row, int col) {
        String command = scanner.nextLine();
        while (!command.equals("danger")) {
            int lastRow = row;
            int lastCol = col;
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
                matrix[lastRow][lastCol] = 'M';
                System.out.printf("No more cheese for tonight!%n");
                break;
            }
            if (col < 0 || col > matrix[0].length - 1) {
                matrix[lastRow][lastCol] = 'M';
                System.out.printf("No more cheese for tonight!%n");
                break;
            }
            char symbol = matrix[row][col];
            if (symbol == 'C') {
                matrix[row][col] = 'M';
                boolean isLastCheese = checkForCheese(matrix);
                if (isLastCheese) {
                    System.out.printf("Happy mouse! All the cheese is eaten, good night!%n");
                    break;
                }
            } else if (symbol == 'T') {
                matrix[row][col] = 'M';
                System.out.printf("Mouse is trapped!%n");
                break;
            } else if (symbol == '@') {
                row = lastRow;
                col = lastCol;
                matrix[lastRow][lastCol] = 'M';
            }
            command = scanner.nextLine();
        }
        if (command.equals("danger")) {
            System.out.printf("Mouse will come back later!%n");
        }
        printMouse(matrix);
    }

    private static boolean checkForCheese(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'C') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printMouse(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                stringBuilder.append(matrix[rows][cols]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
