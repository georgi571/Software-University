package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _07Crossfire_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> matrix = getMatrix(scanner);
        List<List<Integer>> newMatrix = getNewMatrix(scanner, matrix);
        printOutput(newMatrix);
    }
    private static List<List<Integer>> getMatrix(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = size[0];
        int col = size[1];
        int number = 1;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int rows = 0; rows < row; rows++) {
            List<Integer> newList = new ArrayList<>();
            for (int cols = 0; cols < col; cols++) {
                newList.add(number);
                number++;
            }
            matrix.add(newList);
        }
        return matrix;
    }
    private static List<List<Integer>> getNewMatrix(Scanner scanner, List<List<Integer>> matrix) {
        String text = scanner.nextLine();
        while (!text.equals("Nuke it from orbit")) {
            int[] size = Arrays.stream(text.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = size[0];
            int col = size[1];
            int radius = size[2];
            int rowUp = row - radius;
            int rowDown = row + radius;
            int colLeft = col - radius;
            int colRight = col + radius;
            for (int rows = rowUp; rows <= rowDown; rows++) {
                if (rows >= 0 && rows < matrix.size()) {
                    List<Integer> current = matrix.get(rows);
                    if (rows == row) {
                        for (int cols = colRight; cols >= colLeft; cols--) {
                            if (cols >= 0 && cols < matrix.get(rows).size()) {
                                current.remove(cols);
                            }
                        }
                    } else {
                        if (col >= 0 && col < current.size()) {
                            current.remove(col);
                        }
                    }
                    matrix.set(rows, current);
                }
            }
            matrix.removeIf(List::isEmpty);
            text = scanner.nextLine();
        }
        return matrix;
    }
    private static void printOutput(List<List<Integer>> matrix) {
        for (int rows = 0; rows < matrix.size(); rows++) {
            for (int cols = 0; cols < matrix.get(rows).size(); cols++) {
                System.out.printf("%d ", matrix.get(rows).get(cols));
            }
            System.out.printf("%n");
        }
    }
}
