package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._3MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _06LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        if (fieldSize > 0) {
            int[] fieldWithLadyBugs = new int[fieldSize];
            int[] indexOfLadyBugs = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < indexOfLadyBugs.length; i++) {
                if (indexOfLadyBugs[i] >= 0 && indexOfLadyBugs[i] < fieldSize) {
                    fieldWithLadyBugs[indexOfLadyBugs[i]] = 1;
                }
            }
            String command = scanner.nextLine();
            while (!command.equals("end")) {
                String[] input = command.split(" ");
                int currentIndex = Integer.parseInt(input[0]);
                String side = input[1];
                int moveWithIndex = Integer.parseInt(input[2]);
                if (currentIndex >= 0 && currentIndex < fieldSize) {
                    if (fieldWithLadyBugs[currentIndex] == 1) {
                        fieldWithLadyBugs[currentIndex] = 0;
                        if (side.equals("right")) {
                            for (int i = currentIndex + moveWithIndex; i < fieldWithLadyBugs.length && i >= 0; i += moveWithIndex) {
                                if (fieldWithLadyBugs[i] == 0) {
                                    fieldWithLadyBugs[i] = 1;
                                    break;
                                }
                            }
                        } else if (side.equals("left")) {
                            for (int i = currentIndex - moveWithIndex; i >= 0 && i < fieldWithLadyBugs.length; i -= moveWithIndex) {
                                if (fieldWithLadyBugs[i] == 0) {
                                    fieldWithLadyBugs[i] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
                command = scanner.nextLine();
            }
            for (int i = 0; i < fieldWithLadyBugs.length - 1; i++) {
                System.out.printf("%d ", fieldWithLadyBugs[i]);
            }
            System.out.printf("%d", fieldWithLadyBugs[fieldWithLadyBugs.length - 1]);
        }
    }
}
