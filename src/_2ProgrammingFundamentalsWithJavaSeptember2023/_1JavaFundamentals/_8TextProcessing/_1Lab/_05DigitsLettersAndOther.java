package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._1Lab;

import java.util.Scanner;

public class _05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder isNumber = new StringBuilder();
        StringBuilder isLetter = new StringBuilder();
        StringBuilder isSymbol = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Character.isDigit(currentChar)) {
                isNumber.append(currentChar);
            } else if (Character.isLetter(currentChar)) {
                isLetter.append(currentChar);
            } else {
                isSymbol.append(currentChar);
            }
        }
        System.out.println(isNumber.toString());
        System.out.println(isLetter.toString());
        System.out.println(isSymbol.toString());
    }
}
