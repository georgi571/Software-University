package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._2Exercise;

import java.util.Scanner;

public class _06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder newText = new StringBuilder();
        newText.append(text.charAt(0));
        for (int i = 1; i < text.length(); i++) {
            char oldPosition = text.charAt(i - 1);
            char newPosition = text.charAt(i);
            if (oldPosition != newPosition) {
                newText.append(newPosition);
            }
        }
        System.out.printf("%s", newText);
    }
}
