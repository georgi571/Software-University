package _0Softuniada._2017;

import java.util.Scanner;

public class _03DuplicatedLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder command = new StringBuilder(scanner.nextLine());
        int counter = 0;
        boolean isDone = false;
        while (!isDone) {
            for (int i = 0; i < command.length(); i++) {
                if (i < command.length() - 1) {
                    if (command.charAt(i) == command.charAt(i + 1)) {
                        command.delete(i, i + 2);
                        counter++;
                        if (command.length() == 0) {
                            isDone = true;
                        }
                        break;
                    }
                } else {
                    isDone = true;
                }
            }
        }
        if (command.length() == 0) {
            System.out.printf("Empty String%n");
        } else {
            System.out.printf("%s%n", command.toString());
        }
        System.out.printf("%d operations", counter);
    }
}
