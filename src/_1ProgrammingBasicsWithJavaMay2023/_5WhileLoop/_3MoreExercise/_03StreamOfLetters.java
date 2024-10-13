package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._3MoreExercise;

import java.util.Scanner;

public class _03StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counterC = 0;
        int counterO = 0;
        int counterN = 0;
        String word = "";
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            char letter = command.charAt(0);
            if (Character.isAlphabetic(letter)) {
                if (letter == 'c') {
                    counterC += 1;
                    if (counterC > 1) {
                        word += letter;
                        command = scanner.nextLine();
                    } else {
                        command = scanner.nextLine();
                    }
                } else if (letter == 'o') {
                    counterO += 1;
                    if (counterO > 1) {
                        word += letter;
                        command = scanner.nextLine();
                    } else {
                        command = scanner.nextLine();
                    }
                } else if (letter == 'n') {
                    counterN += 1;
                    if (counterN > 1) {
                        word += letter;
                        command = scanner.nextLine();
                    } else {
                        command = scanner.nextLine();
                    }
                } else {
                    word += letter;
                    command = scanner.nextLine();
                }
            } else {
                command = scanner.nextLine();
            }
            if (counterO >= 1 && counterC >= 1 && counterN >= 1) {
                System.out.print(word + " ");
                counterN = 0;
                counterO = 0;
                counterC = 0;
                word = "";
            }
        }
    }
}
