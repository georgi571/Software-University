package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = readMatrix(scanner);
        printOutput(scanner, matrix);
    }
    private static String[][] readMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] array = scanner.nextLine().split("\\s+");
            matrix[row] = array;
        }
        return matrix;
    }
    private static void printOutput(Scanner scanner, String[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandParts = command.split("\\s+");
            if (commandParts.length != 5 || !commandParts[0].equals("swap")) {
                System.out.printf("Invalid input!%n");
            } else {
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);
                if (row1 > row - 1 || row2 > row - 1 || col1 > col - 1 || col2 > col - 1 || row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0) {
                    System.out.printf("Invalid input!%n");
                } else {
                    String element1 = matrix[row1][col1];
                    String element2 = matrix[row2][col2];
                    matrix[row1][col1] = element2;
                    matrix[row2][col2] = element1;
                    for (int rows = 0; rows < matrix.length; rows++) {
                        for (int cols = 0; cols < matrix[rows].length; cols++) {
                            System.out.printf("%s ", matrix[rows][cols]);
                        }
                        System.out.printf("%n");
                    }
                }
            }
            command = scanner.nextLine();
        }
    }
}
