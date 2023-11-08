package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String bannedWord : bannedWords) {
            String replacement = genRepelacement(bannedWord);
            text = text.replace(bannedWord, replacement);
        }
        System.out.printf("%s", text);
    }
    private static String genRepelacement(String bannedWord) {
        char[] replacementCharArray = new char[bannedWord.length()];
        Arrays.fill(replacementCharArray, '*');
        return new String(replacementCharArray);
    }
}
