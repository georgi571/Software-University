package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._1Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryNew = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistory.size() > 1) {
                    browserHistoryNew.addFirst(browserHistory.pop());
                    System.out.printf("%s%n", browserHistory.peek());
                } else {
                    System.out.printf("no previous URLs%n");
                }
            } else if (input.equals("forward")) {
                if (!browserHistoryNew.isEmpty()) {
                    browserHistory.push(browserHistoryNew.pop());
                    System.out.printf("%s%n",browserHistory.peek());
                } else {
                    System.out.printf("no next URLs%n");
                }
            } else {
                browserHistory.push(input);
                browserHistoryNew.clear();
                System.out.printf("%s%n", browserHistory.peek());
            }
            input = scanner.nextLine();
        }
    }
}
