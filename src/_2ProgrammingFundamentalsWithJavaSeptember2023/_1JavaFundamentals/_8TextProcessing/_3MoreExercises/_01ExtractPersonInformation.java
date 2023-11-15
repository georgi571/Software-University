package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._3MoreExercises;

import java.util.Scanner;

public class _01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number; i++) {
            String text = scanner.nextLine();
            StringBuilder name = new StringBuilder();
            StringBuilder age = new StringBuilder();
            for (int j = 0; j < text.length(); j++) {
                char currentCharFor = text.charAt(j);
                if (text.charAt(j) == '@') {
                    int charNumber = j + 1;
                    while (text.charAt(charNumber) != '|') {
                        char currentChar = text.charAt(charNumber);
                        name.append(currentChar);
                        charNumber++;
                    }
                    j += charNumber - j;
                } else if (text.charAt(j) == '#') {
                    int charNumber = j + 1;
                    while (text.charAt(charNumber) != '*') {
                        char currentChar = text.charAt(charNumber);
                        age.append(currentChar);
                        charNumber++;
                    }
                    j += charNumber - j;
                }
            }
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
