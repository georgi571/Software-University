package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._2Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        ArrayDeque<Character> symbols = new ArrayDeque<>();
        boolean isBalanced = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(' || text.charAt(i) == '{' || text.charAt(i) == '[') {
                symbols.push(text.charAt(i));
            } else {
                if (!symbols.isEmpty()) {
                    if (text.charAt(i) == ')') {
                        if (symbols.pop() == '(') {
                            isBalanced = true;
                        } else {
                            isBalanced = false;
                            break;
                        }
                    } else if (text.charAt(i) == '}') {
                        if (symbols.pop() == '{') {
                            isBalanced = true;
                        } else {
                            isBalanced = false;
                            break;
                        }
                    } else if (text.charAt(i) == ']') {
                        if (symbols.pop() == '[') {
                            isBalanced = true;
                        } else {
                            isBalanced = false;
                            break;
                        }
                    }
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.printf("YES%n");
        } else {
            System.out.printf("NO%n");
        }
    }
}
