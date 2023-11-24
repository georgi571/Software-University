package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._1Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> fileName = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!command.equals("print")) {
            if (!command.equals("cancel")) {
                fileName.offer(command);
            } else {
                if (!fileName.isEmpty()) {
                    System.out.printf("Canceled %s%n", fileName.pollFirst());
                } else {
                    System.out.printf("Printer is on standby%n");
                }
            }
            command = scanner.nextLine();
        }
        while (!fileName.isEmpty()) {
            System.out.printf("%s%n", fileName.pollFirst());
        }
    }
}
