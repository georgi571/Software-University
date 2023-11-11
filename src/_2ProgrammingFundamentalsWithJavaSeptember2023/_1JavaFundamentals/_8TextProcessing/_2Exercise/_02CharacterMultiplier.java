package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._2Exercise;

import java.util.Scanner;

public class _02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(" ");
        String leftText = text[0];
        String rightText = text[1];
        getSumOfText(leftText, rightText);
    }

    private static void getSumOfText(String leftText, String rightText) {
        int sum = 0;
        int maxLength = Math.max(leftText.length(), rightText.length());
        int minLength = Math.min(leftText.length(), rightText.length());
        for (int i = 0; i < minLength; i++) {
            sum += (leftText.charAt(i) * rightText.charAt(i));
        }
        if (leftText.length() == rightText.length()) {
            System.out.printf("%d", sum);
        } else if (leftText.length() > rightText.length()) {
            for (int i = minLength; i < leftText.length() ; i++) {
                sum += leftText.charAt(i);
            }
            System.out.printf("%d", sum);
        } else {
            for (int i = minLength; i < rightText.length() ; i++) {
                sum += rightText.charAt(i);
            }
            System.out.printf("%d", sum);
        }
    }
}
