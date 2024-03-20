package _0Softuniada._2023;

import java.util.Scanner;

public class _03LongestValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int longest = 0;
        int current = 0;
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == '(' && i < text.length() - 1) {
                char nextChar = text.charAt(i + 1);
                if (nextChar == ')') {
                    current += 2;
                    i++;
                } else {
                    if (current > longest) {
                        longest = current;
                    }
                    current = 0;
                }
            }
        }
        if (current > longest) {
            longest = current;
        }
        System.out.printf("%d", longest);
    }
}
