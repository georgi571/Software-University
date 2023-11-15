package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._3MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class _03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] keys = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        String command = scanner.nextLine();
        while (!command.equals("find")) {
            StringBuilder treasure = new StringBuilder();
            StringBuilder mine = new StringBuilder();
            StringBuilder coordinates = new StringBuilder();
            int key = 0;
            int mineCounter = 0;
            int coordinatesCounter = 0;
            for (int i = 0; i < command.length(); i++) {
                char currentChar = command.charAt(i);
                currentChar -= keys[key];
                treasure.append(currentChar);
                if (currentChar == '&') {
                    mineCounter++;
                }
                if (currentChar != '&' && mineCounter == 1) {
                    mine.append(currentChar);
                }
                if (currentChar == '<') {
                    coordinatesCounter++;
                }
                if (currentChar == '>') {
                    coordinatesCounter++;
                }
                if (currentChar != '<' && coordinatesCounter == 1) {
                    coordinates.append(currentChar);
                }
                if (key == keys.length - 1) {
                    key = 0;
                } else {
                    key++;
                }
            }
            System.out.printf("Found %s at %s%n", mine, coordinates);
            command = scanner.nextLine();
        }
    }
}
