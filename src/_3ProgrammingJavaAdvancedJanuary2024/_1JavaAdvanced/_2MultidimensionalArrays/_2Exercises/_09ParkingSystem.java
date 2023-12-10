package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[][] parkingMatrix = readMatrix(scanner);
        printOutput(parkingMatrix, scanner);
    }
    private static boolean[][] readMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        boolean[][] parkingMatrix = new boolean[rows][cols];
        for (int row = 0; row < parkingMatrix.length; row++) {
            parkingMatrix[row][0] = true;
        }
        return parkingMatrix;
    }
    private static void printOutput(boolean[][] parkingMatrix, Scanner scanner) {
        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            int[] enters = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int enterRow = enters[0];
            int row = enters[1];
            int col = enters[2];
            if (isRowHaveSpace(parkingMatrix, row)) {
                int counter = Math.abs(row - enterRow) + 1;
                if (!parkingMatrix[row][col]) {
                    parkingMatrix[row][col] = true;
                    System.out.printf("%d%n", counter + col);
                } else {
                    int positionMinus = col - 1;
                    int positionPlus = col + 1;
                    while (positionMinus > 0 || positionPlus < parkingMatrix[row].length) {
                        if (positionMinus > 0) {
                            if (!parkingMatrix[row][positionMinus]) {
                                parkingMatrix[row][positionMinus] = true;
                                System.out.printf("%d%n", counter + positionMinus);
                                break;
                            }
                            positionMinus--;
                        }
                        if (positionPlus < parkingMatrix[row].length) {
                            if (!parkingMatrix[row][positionPlus]) {
                                parkingMatrix[row][positionPlus] = true;
                                System.out.printf("%d%n", counter + positionPlus);
                                break;
                            }
                            positionPlus++;
                        }
                    }
                }
            } else {
                System.out.printf("Row %d full%n", row);
            }
            command = scanner.nextLine();
        }
    }
    private static boolean isRowHaveSpace(boolean[][] parkingMatrix, int row) {
        for (int i = 1; i < parkingMatrix[row].length; i++) {
            if (!parkingMatrix[row][i]) {
                return true;
            }
        }
        return false;
    }
}
