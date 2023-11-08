package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._1Lab;

import java.util.Scanner;

public class _01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String word = command;
            String reversedWord = reverseWord(word);
            System.out.printf("%s = %s%n", word, reversedWord);
            command = scanner.nextLine();
        }
    }
    private static String reverseWord(String word) {
        char[] reversedResult = new char[word.length()];
        int reversedIndex = 0;
        for (int i = word.length() - 1; i >= 0 ; i--) {
            char currentChar = word.charAt(i);
            reversedResult[reversedIndex] = currentChar;
            reversedIndex++;
        }
        return new String(reversedResult);
    }
}
