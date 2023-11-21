package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._3MoreExersice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.sort;

public class _02RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toUpperCase();
        List<Character> chars = new ArrayList<>();
        int differentChars = 0;
        StringBuilder finalText = new StringBuilder();
        Pattern pattern = Pattern.compile("(?<symbol>[\\D]*)(?<numbers>[\\d]{1,2})");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String currentMatch = matcher.group("symbol");
            int number = Integer.parseInt(matcher.group("numbers"));
            for (int i = 1; i <= number; i++) {
                finalText.append(currentMatch);
            }
        }
        for (int i = 0; i < finalText.length(); i++) {
            char current = finalText.charAt(i);
            if (!chars.contains(current)) {
                chars.add(current);
                differentChars++;
            }
        }
        System.out.printf("Unique symbols used: %d%n", differentChars);
        System.out.printf("%s%n", finalText);
    }
}