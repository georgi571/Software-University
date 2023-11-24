package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._1Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if (!input.equals("back")) {
                browserHistory.push(input);
                System.out.printf("%s%n", browserHistory.peek());
            } else {
                if (browserHistory.size() > 1) {
                    browserHistory.pop();
                    System.out.printf("%s%n", browserHistory.peek());
                } else {
                    System.out.printf("no previous URLs%n");
                }
            }
            input = scanner.nextLine();
        }
    }
}
