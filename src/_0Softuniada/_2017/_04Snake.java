package _0Softuniada._2017;

import javax.swing.text.Position;
import java.util.Scanner;

public class _04Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][][] matrix = new char[n][n][n];
        for (int layer = 0; layer < n; layer++) {
            String[] layerData = scanner.nextLine().split(" \\| ");
            for (int row = 0; row < n; row++) {
                matrix[row][layer] = layerData[row].toCharArray();
            }
        }
        String initialDirection = scanner.nextLine();
        int points = 0;
        Position snakePosition = findStartPosition(matrix, n);
        String currentDirection = initialDirection;
        boolean isNextEnd = false;
        while (!isNextEnd) {
            String[] line = scanner.nextLine().split("\\s+");
            if (line[0].equals("end")) {
                isNextEnd = true;
            }
            String direction = line[0];
            int steps = Integer.parseInt(line[2]);
            for (int i = 0; i < steps; i++) {
                matrix[snakePosition.layer][snakePosition.row][snakePosition.col] = 'o';
                snakePosition = getNextPosition(snakePosition, currentDirection, n);
                if (snakePosition == null || !isValidPosition(snakePosition, n)) {
                    System.out.printf("Points collected: %d%n", points);
                    System.out.printf("The snake dies.%n");
                    return;
                }
                char nextCell = matrix[snakePosition.layer][snakePosition.row][snakePosition.col];
                if (nextCell == 'a') {
                    points++;
                }
                matrix[snakePosition.layer][snakePosition.row][snakePosition.col] = 's';
            }
            currentDirection = direction;
        }
        System.out.printf("Points collected: %d", points);
    }
    private static Position findStartPosition(char[][][] matrix, int n) {
        for (int layer = 0; layer < n; layer++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (matrix[layer][row][col] == 's') {
                        return new Position(layer, row, col);
                    }
                }
            }
        }
        return null;
    }

    private static Position getNextPosition(Position currentPosition, String direction, int n) {
        int layer = currentPosition.layer;
        int row = currentPosition.row;
        int col = currentPosition.col;
        if (direction.equals("forward")) {
            row--;
        } else if (direction.equals("backward")) {
            row++;
        } else if (direction.equals("up")) {
            layer--;
        } else if (direction.equals("down")) {
            layer++;
        } else if (direction.equals("left")) {
            col--;
        } else if (direction.equals("right")) {
            col++;
        }
        return new Position(layer, row, col);
    }

    private static boolean isValidPosition(Position position, int n) {
        return position.layer >= 0 && position.layer < n &&
                position.row >= 0 && position.row < n &&
                position.col >= 0 && position.col < n;
    }

    private static class Position {
        int layer;
        int row;
        int col;

        Position(int layer, int row, int col) {
            this.layer = layer;
            this.row = row;
            this.col = col;
        }
    }
}


