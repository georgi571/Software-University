package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._3MoreExersice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            StringBuilder newText = new StringBuilder();
            for (int i = 0; i < command.length(); i++) {
                char currentChar = command.charAt(i);
                char newChar = (char) (currentChar - n);
                newText.append(newChar);
            }
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]+!(?<good>[GN])!");
            Matcher matcher = pattern.matcher(newText);
            while (matcher.find()) {
                String name = matcher.group("name");
                String goodOrBad = matcher.group("good");
                if (goodOrBad.equals("G")) {
                    System.out.printf("%s%n",name);
                }
            }
            command = scanner.nextLine();
        }
    }
}
