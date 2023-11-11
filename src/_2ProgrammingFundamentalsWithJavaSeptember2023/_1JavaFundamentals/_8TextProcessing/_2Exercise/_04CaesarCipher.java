package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._2Exercise;

import java.util.Scanner;

public class _04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            currentChar+= 3;
            newText.append(currentChar);
        }
        System.out.printf("%s", newText);
    }
}
