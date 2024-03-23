package _0Softuniada._2020;

import java.util.Arrays;
import java.util.Scanner;

public class _04SoftJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = size[0];
        int col = size[1];
        char[][] matrix = new char[row][col];
        int playerRow = row - 1;
        int playerCol = -1;
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        for (int i = 0; i < matrix[row - 1].length; i++) {
            if (matrix[playerRow][i] == 'S') {
                playerCol = i;
            }
        }
        int maxJumps = Integer.parseInt(scanner.nextLine());
        int totalJumps = 0;
        for (int i = 0; i < maxJumps; i++) {
            int[] moves = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int rowToMove = moves[0];
            int stepsToMove = moves[1];
            int steps = stepsToMove % col;
            for (int j = 0; j < steps; j++) {
                char[] newRow = new char[col];
                for (int k = 0; k < matrix[rowToMove].length; k++) {
                    if (k == 0) {
                        newRow[k] = matrix[rowToMove][col - 1];
                    } else {
                        newRow[k] = matrix[rowToMove][k - 1];
                    }
                }
                matrix[rowToMove] = newRow;
            }
            if (playerRow - 1 == rowToMove && matrix[rowToMove][playerCol] == '-') {
                playerRow = rowToMove;
                totalJumps++;
            }
        }
        if (playerRow == 0) {
            System.out.printf("Win%n");
        } else {
            System.out.printf("Lose%n");
        }
        matrix[row - 1][playerCol] = '0';
        matrix[playerRow][playerCol] = 'S';
        System.out.printf("Total Jumps: %d%n", totalJumps);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                stringBuilder.append(String.format("%c", matrix[i][j]));
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.printf("%s", stringBuilder);
    }
}
