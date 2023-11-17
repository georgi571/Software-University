package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._2Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String email = "\\b[A-Za-z0-9]+[\\.\\-\\_]?[A-Za-z0-9]+@[A-Za-z]+\\-?[\\.A-Za-z]+([A-Za-z]+\\-?[\\.A-Za-z]+)+\\b";
        Pattern pattern = Pattern.compile(email);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.printf("%s%n", matcher.group());
        }
    }
}
