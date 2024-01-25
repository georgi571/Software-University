package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._08JavaAdvancedRegularExam22October2022;

import java.util.Scanner;

public class _02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        char[][] matrix = fillMatrix(size, scanner);
        playRallyRacing(scanner, matrix, racingNumber);
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][];
        for (int rows = 0; rows < size; rows++) {
            char[] input = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[rows] = input;
        }
        return matrix;
    }

    private static void playRallyRacing(Scanner scanner, char[][] matrix, String racingNumber) {
        int row = 0;
        int col = 0;
        int km = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            km += 10;
            if (command.equals("up")) {
                row--;
            } else if (command.equals("down")) {
                row++;
            } else if (command.equals("left")) {
                col--;
            } else if (command.equals("right")) {
                col++;
            }
            char symbol = matrix[row][col];
            if (symbol == 'T') {
                km += 20;
                matrix[row][col] = '.';
                int rowT = getRow(matrix);
                int colT = getRowCol(matrix);
                matrix[rowT][colT] = '.';
                row = rowT;
                col = colT;
            } else if (symbol == 'F') {
                System.out.printf("Racing car %s finished the stage!%n", racingNumber);
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        matrix[row][col] = 'C';
        System.out.printf("Distance covered %d km.%n", km);
        printRallyRacing(matrix);
    }

    private static int getRow(char[][] matrix) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'T') {
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
                if (matrix[i][j] == 'T') {
                    col = j;
                }
            }
        }
        return col;
    }

    private static void printRallyRacing(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
