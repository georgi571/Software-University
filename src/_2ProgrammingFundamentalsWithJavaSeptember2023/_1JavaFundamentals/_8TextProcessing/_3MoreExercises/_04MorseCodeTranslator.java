package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._3MoreExercises;

import java.util.Scanner;

public class _04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder morseCode = new StringBuilder();
        String[] words = scanner.nextLine().split("\\s+\\|\\s+");
        for (int i = 0; i < words.length; i++) {
            String[] currentWord = words[i].split(" ");
            for (int j = 0; j < currentWord.length; j++) {
                String charFromWord = currentWord[j];
                char charForMorse = getLetterFromMorseCode(charFromWord);
                morseCode.append(charForMorse);
            }
            morseCode.append(" ");
        }
        morseCode.deleteCharAt(morseCode.length() - 1);
        System.out.printf("%s", morseCode);
    }
    private static char getLetterFromMorseCode(String code) {
        char currentChar = '0';
        if (code.equals(".-")) {
            currentChar = 'A';
        } else if (code.equals("-...")) {
            currentChar = 'B';
        } else if (code.equals("-.-.")) {
            currentChar = 'C';
        } else if (code.equals("-..")) {
            currentChar = 'D';
        } else if (code.equals(".")) {
            currentChar = 'E';
        } else if (code.equals("..-.")) {
            currentChar = 'F';
        } else if (code.equals("--.")) {
            currentChar = 'G';
        } else if (code.equals("....")) {
            currentChar = 'H';
        } else if (code.equals("..")) {
            currentChar = 'I';
        } else if (code.equals(".---")) {
            currentChar = 'J';
        } else if (code.equals("-.-")) {
            currentChar = 'K';
        } else if (code.equals(".-..")) {
            currentChar = 'L';
        } else if (code.equals("--")) {
            currentChar = 'M';
        } else if (code.equals("-.")) {
            currentChar = 'N';
        } else if (code.equals("---")) {
            currentChar = 'O';
        } else if (code.equals(".--.")) {
            currentChar = 'P';
        } else if (code.equals("--.-")) {
            currentChar = 'Q';
        } else if (code.equals(".-.")) {
            currentChar = 'R';
        } else if (code.equals("...")) {
            currentChar = 'S';
        } else if (code.equals("-")) {
            currentChar = 'T';
        } else if (code.equals("..-")) {
            currentChar = 'U';
        } else if (code.equals("...-")) {
            currentChar = 'V';
        } else if (code.equals(".--")) {
            currentChar = 'W';
        } else if (code.equals("-..-")) {
            currentChar = 'X';
        } else if (code.equals("-.--")) {
            currentChar = 'Y';
        } else if (code.equals("--..")) {
            currentChar = 'Z';
        }
        return currentChar;
    }
}
