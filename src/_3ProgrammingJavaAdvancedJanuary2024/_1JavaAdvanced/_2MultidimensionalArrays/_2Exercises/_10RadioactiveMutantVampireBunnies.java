package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] liar = getMatrix(scanner);
        printOutput(scanner, liar);
    }
    private static char[][] getMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int rows = size[0];
        int cols = size[1];
        char[][] liar = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            liar[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return liar;
    }
    private static void printOutput(Scanner scanner, char[][] liar) {
        int x = 0;
        int y = 0;
        for (int row = 0; row < liar.length; row++) {
            for (int col = 0; col < liar[row].length; col++) {
                if (liar[row][col] == 'P') {
                    x = row;
                    y = col;
                }
            }
        }
        char[] playersMove = scanner.nextLine().toCharArray();
        for (int i = 0; i < playersMove.length; i++) {
            boolean isPlyaerWon = false;
            boolean isPlayerAlive = true;
            if (playersMove[i] == 'U') {
                if (x - 1 == -1) {
                    isPlyaerWon = true;
                } else if (liar[x - 1][y] == '.') {
                    liar[x][y] = '.';
                    x = x - 1;
                    liar[x][y] = 'P';
                } else if (liar[x - 1][y] == 'B') {
                    x = x - 1;
                    isPlayerAlive = false;
                }
            } else if (playersMove[i] == 'R') {
                if (y + 1 == liar[x].length) {
                    isPlyaerWon = true;
                } else if (liar[x][y + 1] == '.') {
                    liar[x][y] = '.';
                    y = y + 1;
                    liar[x][y] = 'P';
                } else if (liar[x][y + 1] == 'B') {
                    y = y + 1;
                    isPlayerAlive = false;
                }
            } else if (playersMove[i] == 'D') {
                if (x + 1 == liar.length) {
                    isPlyaerWon = true;
                } else if (liar[x + 1][y] == '.') {
                    liar[x][y] = '.';
                    x = x + 1;
                    liar[x][y] = 'P';
                } else if (liar[x + 1][y] == 'B') {
                    x = x + 1;
                    isPlayerAlive = false;
                }
            } else if (playersMove[i] == 'L') {
                if (y - 1 == -1) {
                    isPlyaerWon = true;
                } else if (liar[x][y - 1] == '.') {
                    liar[x][y] = '.';
                    y = y - 1;
                    liar[x][y] = 'P';
                }  else if (liar[x][y - 1] == 'B') {
                    y = y - 1;
                }
            }
            char[][] newMatrix = getNewMatrix(liar);
            for (int row = 0; row < liar.length; row++) {
                for (int col = 0; col < liar[row].length; col++) {
                    if (liar[row][col] == 'B') {
                        newMatrix[row][col] = 'B';
                        if (row > 0) {
                            newMatrix[row - 1][col] = 'B';
                        }
                        if (col < liar[row].length - 1) {
                            newMatrix[row][col + 1] = 'B';
                        }
                        if (row < liar.length - 1) {
                            newMatrix[row + 1][col] = 'B';
                        }
                        if (col > 0) {
                            newMatrix[row][col - 1] = 'B';
                        }
                    }
                }
            }
            liar = newMatrix;
            if (liar[x][y] == 'B') {
                isPlayerAlive = false;
            } else if (liar[x][y] == '.') {
                liar[x][y] = 'P';
            }
            if (isPlyaerWon) {
                if (liar[x][y] == 'P') {
                    liar[x][y] = '.';
                }
                printMatrix(liar);
                System.out.printf("won: %d %d%n", x, y);
                break;
            }
            if (!isPlayerAlive) {
                printMatrix(liar);
                System.out.printf("dead: %d %d%n", x, y);
                break;
            }
        }
    }
    private static char[][] getNewMatrix(char[][] liar) {
        char[][] newMatrix = new char[liar.length][liar[0].length];
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {
                newMatrix[row][col] = '.';
            }
        }
        return newMatrix;
    }
    private static void printMatrix(char[][] liar) {
        for (int rows = 0; rows < liar.length; rows++) {
            for (int cols = 0; cols < liar[rows].length; cols++) {
                System.out.printf("%c", liar[rows][cols]);
            }
            System.out.printf("%n");
        }
    }
}
