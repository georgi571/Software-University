package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._2Exersices._05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = fillMatrix(scanner);
        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] heroCoordinates = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];
            moveEvil(evilRow, evilCol, matrix);
            int heroRow = heroCoordinates[0];
            int heroCol = heroCoordinates[1];
            moveHero(heroRow, heroCol, matrix);
            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static int[][] fillMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = dimensions[0];
        int y = dimensions[1];
        int[][] matrix = new int[x][y];
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

    private static long sum = 0;

    private static void moveEvil(int row, int col, int[][] matrix) {
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[0].length) {
                    matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    private static void moveHero(int row, int col, int[][] matrix) {
        while (row >= 0 && col < matrix[0].length) {
            if (row < matrix.length && col >= 0) {
                sum += matrix[row][col];
            }
            row--;
            col++;
        }
    }
}
