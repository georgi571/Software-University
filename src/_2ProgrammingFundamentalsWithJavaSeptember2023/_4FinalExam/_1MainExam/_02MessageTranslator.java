package _2ProgrammingFundamentalsWithJavaSeptember2023._4FinalExam._1MainExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("(!)(?<command>[A-Z][a-z]{2,})(!):(\\[)(?<text>[A-Za-z]{8,})(\\])");
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String groupText = matcher.group("text");
                System.out.printf("%s: ", matcher.group("command"));
                for (int j = 0; j < groupText.length(); j++) {
                    System.out.printf("%d ",(int) groupText.charAt(j));
                }
                System.out.printf("%n");
            } else {
                System.out.printf("The message is invalid%n");
            }
        }
    }
}
