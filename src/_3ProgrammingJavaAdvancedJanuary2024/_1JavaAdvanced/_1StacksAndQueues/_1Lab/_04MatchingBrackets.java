package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._1Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> position = new ArrayDeque<>();
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == '(') {
                position.push(i);
            } else if (currentChar == ')'){
                System.out.printf("%s%n", text.substring(position.pop(), i + 1));
            }
        }
    }
}
