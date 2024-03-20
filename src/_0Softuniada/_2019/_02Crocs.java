package _0Softuniada._2019;

import java.util.Scanner;

public class _02Crocs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        int height = n * 4 + 2;
        int weight = n * 5;
        int lines = n / 2;
        int counter = 0;
        int finalCounter = 0;
        boolean isFinal = false;
        boolean isStart = false;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (i < lines || i >= height - lines) {
                    if (j < n || j > weight - n - 1) {
                        stringBuilder.append(" ");
                    } else {
                        stringBuilder.append("#");
                    }
                } else if (i == lines) {
                    if (j < n || j > weight - n - 1) {
                        stringBuilder.append("#");
                    } else {
                        stringBuilder.append(" ");
                    }
                } else if (i < lines + n * 2 && counter % 2 == 0) {
                    isStart = true;
                    if (j < n || j > weight - n) {
                        stringBuilder.append("#");
                    } else if (j % 2 == 1) {
                        stringBuilder.append(" ");
                    } else {
                        stringBuilder.append("#");
                    }
                } else if (i < lines + n * 2 && counter % 2 == 1) {
                    if (j < n || j > weight - n - 1) {
                        stringBuilder.append("#");
                    } else if (j == n || j == weight - n - 1) {
                        stringBuilder.append(" ");
                    } else if (j % 2 == 1) {
                        stringBuilder.append("#");
                    } else {
                        stringBuilder.append(" ");
                    }
                } else if (i == lines + n * 2) {
                    if (j < n || j > weight - n - 1) {
                        stringBuilder.append("#");
                    } else {
                        stringBuilder.append(" ");
                    }
                } else {
                    if (finalCounter % 2 == 0) {
                        isFinal = true;
                        stringBuilder.append("#");
                    } else {
                        if (j < n || j > weight - n - 1) {
                            stringBuilder.append("#");
                        } else if (j == n || j == weight - n - 1) {
                            stringBuilder.append(" ");
                        } else if (j % 2 == 1) {
                            stringBuilder.append(" ");
                        } else {
                            stringBuilder.append("#");
                        }
                    }
                }
            }
            if (isFinal) {
                finalCounter++;
            } else if (isStart) {
                counter++;
            }
            stringBuilder.append(System.lineSeparator());
        }
        System.out.printf("%s", stringBuilder);
    }
}
