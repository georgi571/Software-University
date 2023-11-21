package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._9RegularExpressions._3MoreExersice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("\\|");
        String letters = "";
        int assci = 0;
        int numbers = 0;
        String[] words = text[2].split("\\s+");
        List<Integer> codes = new ArrayList<>();
        List<Integer> letterLength = new ArrayList<>();
        Pattern pattern1 = Pattern.compile("([#\\$%*&])(?<text>[A-Z]+)(\\1)");
        Pattern pattern2 = Pattern.compile("(?<assci>\\d{2}):(?<numbers>\\d{2})");
        Matcher matcher1 = pattern1.matcher(text[0]);
        Matcher matcher2 = pattern2.matcher(text[1]);
        while (matcher1.find()){
            letters = matcher1.group("text");
        }
        while (matcher2.find()) {
            int left = Integer.parseInt(matcher2.group("assci"));
            int right = Integer.parseInt(matcher2.group("numbers"));
            if (right <= 20) {
                codes.add(left);
                letterLength.add(right);
            }
        }
        for (char codeChar : letters.toCharArray()) {
            char ch = codeChar;
            int code = (int) ch;
            boolean isCodeFind = false;
            for (int j = 0; j < codes.size(); j++) {
                if (codes.get(j) == code) {
                    assci = codes.get(j);
                    numbers = letterLength.get(j);
                    for (String word : words) {
                        if (word.charAt(0) == assci && word.length() == numbers + 1) {
                            System.out.printf("%s%n", word);
                            isCodeFind = true;
                            break;
                        }
                        if (isCodeFind) {
                            break;
                        }
                    }
                    if (isCodeFind) {
                        break;
                    }
                }
            }
        }
    }
}
