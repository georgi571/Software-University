package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._2MultidimensionalArrays._2Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degree = getDegree(scanner);
        List<String> text = getList(scanner);
        int sizeCols = getMaxLength(text);
        char[][] matrix = getMatrix(text, sizeCols);
        char[][] rotateMatrix = getRotateMatrix(matrix,sizeCols ,degree);
        printOutput(rotateMatrix);
    }
    private static int getDegree(Scanner scanner) {
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<degree>\\d+)");
        Matcher matcher = pattern.matcher(text);
        int degree = 0;
        while (matcher.find()) {
            degree = Integer.parseInt(matcher.group("degree"));
        }
        return degree;
    }
    private static List<String> getList(Scanner scanner) {
        List<String> text = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            text.add(command);
            command = scanner.nextLine();
        }
        return text;
    }
    private static int getMaxLength(List<String> text) {
        int length = 0;
        for (int i = 0; i < text.size(); i++) {
            int currentLength = text.get(i).length();
            if (currentLength > length) {
                length = currentLength;
            }
        }
        return length;
    }
    private static char[][] getMatrix(List<String> text, int sizeCols) {
        int size = text.size();
        char[][] matrix = new char[size][sizeCols];
        for (int i = 0; i < text.size(); i++) {
            char[] array = new char[sizeCols];
            for (int j = 0; j < sizeCols; j++) {
                if (j < text.get(i).length()) {
                    array[j] = text.get(i).charAt(j);
                } else {
                    array[j] = ' ';
                }
            }
            matrix[i] = array;
        }
        return matrix;
    }
    private static char[][] getRotateMatrix(char[][] matrix, int sizeCols, int degree) {
        while (degree > 360) {
            degree -= 360;
        }
        if (degree % 360 == 0) {
            int row = matrix.length;
            int col = sizeCols;
            char[][] rotateMatrix = new char[row][col];
            for (int rows = 0; rows < row; rows++) {
                char[] array = new char[col];
                for (int cols = 0; cols < col; cols++) {
                    array[cols] = matrix[rows][cols];
                }
                rotateMatrix[rows] = array;
            }
            return rotateMatrix;
        } else if (degree % 270 == 0) {
            int row = matrix.length;
            int col = sizeCols;
            char[][] rotateMatrix = new char[col][row];
            for (int cols = 0; cols < col; cols++) {
                char[] array = new char[row];
                for (int rows = 0; rows < row; rows++) {
                    array[rows] = matrix[rows][cols];
                }
                rotateMatrix[col - 1 - cols] = array;
            }
            return rotateMatrix;
        } else if (degree % 180 == 0) {
            int row = matrix.length;
            int col = sizeCols;
            char[][] rotateMatrix = new char[row][col];
            for (int rows = row - 1; rows >= 0; rows--) {
                char[] array = new char[col];
                for (int cols = col - 1; cols >= 0; cols--) {
                    array[cols] = matrix[rows][col - 1 - cols];
                }
                rotateMatrix[row - 1 - rows] = array;
            }
            return rotateMatrix;
        } else if (degree % 90 == 0) {
            int row = matrix.length;
            int col = sizeCols;
            char[][] rotateMatrix = new char[col][row];
            for (int cols = col - 1; cols >= 0; cols--) {
                char[] array = new char[row];
                for (int rows = row - 1; rows >= 0; rows--) {
                    array[rows] = matrix[row - 1 - rows][col - 1 - cols];
                }
                rotateMatrix[col - 1 - cols] = array;
            }
            return rotateMatrix;
        }

        return matrix;
    }
    private static void printOutput(char[][] rotateMatrix) {
        for (int rows = 0; rows < rotateMatrix.length; rows++) {
            for (int cols = 0; cols < rotateMatrix[rows].length; cols++) {
                System.out.printf("%c", rotateMatrix[rows][cols]);
            }
            System.out.printf("%n");
        }
    }
}
