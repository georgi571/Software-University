package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._2Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s");
        ArrayDeque<Character> symbol = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            char currentToken = tokens[i].charAt(0);
            if (Character.isLetterOrDigit(currentToken)) {
                System.out.printf("%s ", tokens[i]);
            } else {
                if (currentToken == '^') {
                    char lastToken = symbol.peek();
                    if (lastToken == '*' || lastToken == '/' || lastToken == '+' || lastToken == '-') {
                        while (!symbol.isEmpty() && !symbol.peek().equals('(') && !symbol.peek().equals('+') && !symbol.peek().equals('-') && !symbol.peek().equals('*') && !symbol.peek().equals('/')) {
                            System.out.printf("%c ", symbol.pop());
                        }
                        symbol.push(currentToken);
                    } else {
                        symbol.push(currentToken);
                    }
                } else if (currentToken == '*') {
                    if (!symbol.isEmpty()) {
                        char lastToken = symbol.peek();
                        if (lastToken == '^' || lastToken == '/') {
                            while (!symbol.isEmpty() && !symbol.peek().equals('(') && !symbol.peek().equals('+') && !symbol.peek().equals('-')) {
                                System.out.printf("%c ", symbol.pop());
                            }
                            symbol.push(currentToken);
                        } else if (lastToken == '*' || lastToken == '+' || lastToken == '-' || lastToken == '(') {
                            symbol.push(currentToken);
                        }
                    } else {
                        symbol.push(currentToken);
                    }
                } else if (currentToken == '/') {
                    if (!symbol.isEmpty()) {
                        char lastToken = symbol.peek();
                        if (lastToken == '^' || lastToken == '*') {
                            while (!symbol.isEmpty() && !symbol.peek().equals('(') && !symbol.peek().equals('+') && !symbol.peek().equals('-')) {
                                System.out.printf("%c ", symbol.pop());
                            }
                            symbol.push(currentToken);
                        } else if (lastToken == '+' || lastToken == '-' || lastToken == '(' || lastToken == '/') {
                            symbol.push(currentToken);
                        }
                    } else {
                        symbol.push(currentToken);
                    }
                } else if (currentToken == '+') {
                    if (!symbol.isEmpty()) {
                        char lastToken = symbol.peek();
                        if (lastToken == '^' || lastToken == '*' || lastToken == '/' || lastToken == '-' || lastToken == '+') {
                            while (!symbol.isEmpty() && !symbol.peek().equals('(')) {
                                System.out.printf("%c ", symbol.pop());
                            }
                            symbol.push(currentToken);
                        } else if (lastToken == '(') {
                            symbol.push(currentToken);
                        }
                    } else {
                        symbol.push(currentToken);
                    }
                } else if (currentToken == '-') {
                    if (!symbol.isEmpty()) {
                        char lastToken = symbol.peek();
                        if (lastToken == '^' || lastToken == '*' || lastToken == '/' || lastToken == '+' || lastToken == '-' || lastToken == '(') {
                            while (!symbol.isEmpty() && !symbol.peek().equals('(')) {
                                System.out.printf("%c ", symbol.pop());
                            }
                            symbol.push(currentToken);
                        }
                    } else {
                        symbol.push(currentToken);
                    }
                } else if (currentToken == '(') {
                    symbol.push(currentToken);
                } else if (currentToken == ')') {
                    char previous = symbol.pop();
                    while (previous != '(') {
                        System.out.printf("%c ", previous);
                        previous = symbol.pop();
                    }
                }
            }
        }
        while (!symbol.isEmpty()) {
            System.out.printf("%c ", symbol.pop());
        }
    }
}
