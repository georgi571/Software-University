package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._2Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> editor = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(commandParts[0]);
            if (command == 1) {
                text.append(commandParts[1]);
                editor.push(text.toString());
            } else if (command == 2) {
                int indexCount = Integer.parseInt(commandParts[1]);
                for (int j = 0; j < indexCount ; j++) {
                    text.deleteCharAt(text.length() - 1);
                }
                editor.push(text.toString());
            } else if (command == 3) {
                int returnIndex = Integer.parseInt(commandParts[1]);
                System.out.printf("%c%n", text.charAt(returnIndex - 1));
            } else if (command == 4) {
                editor.pop();
                if (!editor.isEmpty()) {
                    String newText = editor.peek();
                    text = new StringBuilder(newText);
                } else {
                    text = new StringBuilder();
                }
            }
        }
    }
}
