package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._02JavaAdvancedRegularExam22June2024;

import java.util.Scanner;

public class _02Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = 15;
        char[][] matrix = fillMatrix(scanner);
        int rowP = getRow(matrix, 'B');
        int colP = getRowCol(matrix, 'B');
        playBeesy(scanner, matrix, energy, rowP, colP);
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

    private static void playBeesy(Scanner scanner, char[][] matrix, int energy, int row, int col) {
        boolean isHiveReach = false;
        boolean isRestored = false;
        int unitOfNectar = 0;
        String command = scanner.nextLine();
        while (energy > 0) {
            energy--;
            matrix[row][col] = '-';
            if (command.equals("up")) {
                row--;
                if (row < 0) {
                    row = matrix.length - 1;
                }
            } else if (command.equals("down")) {
                row++;
                if (row > matrix.length - 1) {
                    row = 0;
                }
            } else if (command.equals("left")) {
                col--;
                if (col < 0) {
                    col = matrix[row].length - 1;
                }
            } else if (command.equals("right")) {
                col++;
                if (col > matrix[row].length - 1) {
                    col = 0;
                }
            }
            char symbol = matrix[row][col];
            if (Character.isDigit(symbol)) {
                int amount = Integer.parseInt(String.valueOf(symbol));
                unitOfNectar += amount;
                matrix[row][col] = '-';
            } else if (symbol == 'H') {
                isHiveReach = true;
            }
            if (energy == 0 && unitOfNectar < 30) {
                break;
            } else if (energy == 0 && unitOfNectar >= 30 && !isRestored) {
                energy = unitOfNectar - 30;
                unitOfNectar = 30;
                isRestored = true;
            } else if (energy == 0 && unitOfNectar >= 30 && isRestored) {
                break;
            }
            if (isHiveReach) {
                break;
            }
            command = scanner.nextLine();
        }
        matrix[row][col] = 'B';
        if (isHiveReach && unitOfNectar >= 30) {
            System.out.printf("Great job, Beesy! The hive is full. Energy left: %d%n", energy);
        } else if (isHiveReach && unitOfNectar < 30) {
            System.out.printf("Beesy did not manage to collect enough nectar.%n");
        } else if (!isHiveReach && energy == 0) {
            System.out.printf("This is the end! Beesy ran out of energy.%n");
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }
            System.out.printf("%s%n", stringBuilder);
        }
    }
}
