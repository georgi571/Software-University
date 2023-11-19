package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._5ProgrammingFundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int coolNumber = 1;
        List<String> coolEmojy = new ArrayList<>();
        Pattern patternForNumbers = Pattern.compile("(?<numbers>\\d)");
        Matcher matcherForNumbers = patternForNumbers.matcher(text);
        while (matcherForNumbers.find()) {
            int currentNumber = Integer.parseInt(matcherForNumbers.group("numbers"));
            coolNumber *= currentNumber;
        }
        Pattern patternForEmoji = Pattern.compile("(::|\\*\\*)([A-Z][a-z]{2,})(\\1)");
        Matcher matcherForEmoji = patternForEmoji.matcher(text);
        int validNumber = 0;
        while (matcherForEmoji.find()) {
            String validMatches = matcherForEmoji.group();
            validNumber++;
            String textForMatch = matcherForEmoji.group(2);
            int currentPoints = 0;
            for (char current : textForMatch.toCharArray()) {
                currentPoints += current;
            }
            if (currentPoints >= coolNumber) {
                coolEmojy.add(validMatches);
            }
        }
        System.out.printf("Cool threshold: %d%n", coolNumber);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", validNumber);
        for (int i = 0; i < coolEmojy.size(); i++) {
            System.out.printf("%s%n", coolEmojy.get(i));
        }
    }
}
