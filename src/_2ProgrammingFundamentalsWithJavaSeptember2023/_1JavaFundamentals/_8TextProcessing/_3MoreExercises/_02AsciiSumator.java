package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._3MoreExercises;

import java.util.Scanner;

public class _02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();
        char first;
        char second;
        if (firstSymbol < secondSymbol) {
            first = firstSymbol;
            second = secondSymbol;
        } else {
            first = secondSymbol;
            second = firstSymbol;
        }
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > first && text.charAt(i) < second) {
                sum += text.charAt(i);
            }
        }
        System.out.printf("%d", sum);
    }
}
