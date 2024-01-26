package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._23JavaAdvancedRetakeExam17Dec2019;

import java.util.Scanner;

public class _02PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(size, scanner);
        int row = getRow(matrix);
        int col = getRowCol(matrix);
        playPresentDelivery(scanner, matrix, row, col, count);
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
                if (matrix[i][j] == 'S') {
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
                if (matrix[i][j] == 'S') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void playPresentDelivery(Scanner scanner, char[][] matrix, int row, int col, int count) {
        int present = 0;
        matrix[row][col] = '-';
        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            int lastRow = row;
            int lastCol = col;
            if (command.equals("up")) {
                row--;
            } else if (command.equals("down")) {
                row++;
            } else if (command.equals("left")) {
                col--;
            } else if (command.equals("right")) {
                col++;
            }
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
            char symbol = matrix[row][col];
            if (symbol == 'V') {
                matrix[row][col] = '-';
                present++;
                count--;
            } else if (symbol == 'X') {
                matrix[row][col] = '-';
                count--;
            } else if (symbol == 'C') {
                matrix[row][col] = '-';
                if ((matrix[row - 1][col] == 'V') || (matrix[row - 1][col] == 'X')) {
                    present++;
                    count--;
                    matrix[row - 1][col] = '-';
                }
                if ((matrix[row + 1][col] == 'V') || (matrix[row + 1][col] == 'X')) {
                    present++;
                    count--;
                    matrix[row + 1][col] = '-';
                }
                if ((matrix[row][col - 1] == 'V') || (matrix[row][col - 1] == 'X')) {
                    present++;
                    count--;
                    matrix[row][col - 1] = '-';
                }
                if ((matrix[row][col + 1] == 'V') || (matrix[row][col + 1] == 'X')) {
                    present++;
                    count--;
                    matrix[row][col + 1] = '-';
                }
            }
            if (count <= 0) {
                matrix[row][col] = 'S';
                System.out.printf("Santa ran out of presents!%n");
                break;
            }
            command = scanner.nextLine();
        }
        matrix[row][col] = 'S';
        printPresentDelivery(matrix);
        int niceKid = checkMatrix(matrix);
        if (niceKid > 0) {
            System.out.printf("No presents for %d nice kid/s.%n", niceKid);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", present);
        }
    }

    private static void printPresentDelivery(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j] + " ");
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }

    private static int checkMatrix(char[][] matrix) {
        int niceKid = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'V') {
                    niceKid++;
                }
            }
        }
        return niceKid;
    }
}
