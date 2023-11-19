package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._3ProgrammingFundamentalsFinalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        List<String> reversed = new ArrayList<>();
        List<String> mirror = new ArrayList<>();
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<symbol>[@#])(?<destination>[A-Za-z]{3,})(\\1)(\\1)(?<destinationRevers>[A-Za-z]{3,})(\\1)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group("destination"));
            reversed.add(matcher.group("destinationRevers"));
        }
        if (!words.isEmpty()) {
            System.out.printf("%d word pairs found!%n", words.size());
            int matches = 0;
            for (int i = 0; i < words.size(); i++) {
                String first = words.get(i);
                String second = reversed.get(i);
                StringBuilder check = new StringBuilder(reversed.get(i));
                String reverseWord = String.valueOf(check.reverse());
                if (first.equals(reverseWord)) {
                    String match = first + " <=> " + second;
                    mirror.add(match);
                    matches++;
                }
            }
            if (matches > 0) {
                System.out.printf("The mirror words are:%n");
                System.out.println(String.join(", ", mirror));
            } else {
                System.out.printf("No mirror words!%n");
            }

        } else {
            System.out.printf("No word pairs found!%n");
            System.out.printf("No mirror words!%n");
        }
    }
}
