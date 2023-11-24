package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._1Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kidName = new ArrayDeque<>();
        for (int i = 0; i < names.length; i++) {
            kidName.offer(names[i]);
        }
        while (kidName.size() > 1) {
            for (int i = 1; i < n; i++) {
                kidName.offer(kidName.poll());
            }
            System.out.printf("Removed %s%n", kidName.poll());
        }
        System.out.printf("Last is %s%n", kidName.poll());
    }
}
