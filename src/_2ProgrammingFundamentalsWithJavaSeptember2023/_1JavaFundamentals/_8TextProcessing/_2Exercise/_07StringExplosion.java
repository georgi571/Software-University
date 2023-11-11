package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._2Exercise;

import java.util.Scanner;

public class _07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder newText = new StringBuilder();
        int fromPrevious = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == '>') {
                newText.append(current);
                int number = Integer.parseInt(String.valueOf(text.charAt(i + 1))) + fromPrevious;
                int nextStart = 0;
                for (int j = i + 1; j <= i + number && j < text.length(); j++) {
                    char currentForRemove = text.charAt(j);
                    if (currentForRemove != '>') {
                        nextStart++;
                    } else {
                        newText.append(currentForRemove);
                        fromPrevious = number + i - j;
                        i = j;
                    }
                }
                i += nextStart;
            } else {
                newText.append(current);
            }
        }
        System.out.printf("%s",newText);
    }
}
