package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._2Exercise;

import java.util.Scanner;

public class _08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] codes = scanner.nextLine().split("\\s+");
        double sum = 0.0;
        for (String code : codes) {
            double modifiedNumber = getModifiedNumber(code);
            sum += modifiedNumber;
        }
        System.out.printf("%.2f", sum);
    }

    private static double getModifiedNumber(String code) {
        char firstLetter = code.charAt(0);
        char lastLetter = code.charAt(code.length() - 1);
        Double number = Double.parseDouble(code.replace(firstLetter, ' ').replace(lastLetter, ' ').trim());
        if (Character.isUpperCase(firstLetter)) {
            int positionUpperLetter = (int) firstLetter - 64;
            number /= positionUpperLetter;
        } else {
            int positionLowerLetter = (int) firstLetter - 96;
            number *= positionLowerLetter;
        }
        if (Character.isUpperCase(lastLetter)) {
            int positionUpperLetter = (int) lastLetter - 64;
            number -= positionUpperLetter;
        } else {
            int positionLowerLetter = (int) lastLetter - 96;
            number += positionLowerLetter;
        }
        return number;
    }
}
