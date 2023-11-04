package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._1Lab;

import java.util.Scanner;

public class _07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        String result = reapitingString(text, count);
        System.out.println(result);
    }

    public static String reapitingString(String text, int count) {
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = text;
        }
        return String.join("", result);
    }
}
