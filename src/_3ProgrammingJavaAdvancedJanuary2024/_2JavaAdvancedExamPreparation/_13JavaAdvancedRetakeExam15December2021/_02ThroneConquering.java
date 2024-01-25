package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._13JavaAdvancedRetakeExam15December2021;

import java.util.Scanner;

public class _02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(scanner);
        int rowH = getRow(matrix, 'H');
        int colH = getRowCol(matrix, 'H');
        int rowP = getRow(matrix, 'P');
        int colP = getRowCol(matrix, 'P');
        playThroneConquering(scanner, matrix, rowH, colH, rowP, colP, energy);
    }

    private static char[][] fillMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][];
        for (int rows = 0; rows < size; rows++) {
            char[] input = scanner.nextLine().toCharArray();
            matrix[rows] = input;
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

    private static void playThroneConquering(Scanner scanner, char[][] matrix, int rowH, int colH, int rowP, int colP, int energy) {
        while (energy > 0) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            int row = Integer.parseInt(commandParts[1]);
            int col = Integer.parseInt(commandParts[2]);
            int oldRowP = rowP;
            int oldColP = colP;
            energy--;
            matrix[rowP][colP] = '-';
            if (command.equals("up")) {
                rowP--;
            } else if (command.equals("down")) {
                rowP++;
            } else if (command.equals("left")) {
                colP--;
            } else if (command.equals("right")) {
                colP++;
            }
            if (rowP < 0 || rowP > matrix.length - 1) {
                rowP = oldRowP;
            }
            if (colP < 0 || colP > matrix[0].length - 1) {
                colP = oldColP;
            }
            if (matrix[rowP][colP] == 'S') {
                energy -= 2;
            } else {
                matrix[rowP][colP] = 'P';
            }
            if (rowP == row && colP == col) {
                energy -= 2;
            } else {
                matrix[row][col] = 'S';
            }
            if (rowP == rowH && colP == colH) {
                matrix[rowP][colP] = '-';
                if (energy <= 0) {
                    matrix[rowP][colP] = 'X';
                    System.out.printf("Paris died at %d;%d.%n", rowP, colP);
                    break;
                } else {
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                    break;
                }
            }
            if (energy <= 0) {
                matrix[rowP][colP] = 'X';
                System.out.printf("Paris died at %d;%d.%n", rowP, colP);
                break;
            }
        }
        printThroneConquering(matrix);
    }

    private static void printThroneConquering(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
