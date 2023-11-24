package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._1Lab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> kidName = new PriorityQueue<>();
        int cycle = 1;
        for (int i = 0; i < names.length; i++) {
            kidName.offer(names[i]);
        }
        while (kidName.size() > 1) {
            for (int i = 1; i < n; i++) {
                kidName.offer(kidName.poll());
            }
            if (!isPrimeNumber(cycle)) {
                System.out.printf("Removed %s%n", kidName.poll());
            } else {
                System.out.printf("Prime %s%n",kidName.peek());
            }
            cycle++;
        }
        System.out.printf("Last is %s%n", kidName.poll());
    }

    private static boolean isPrimeNumber(int cycle) {
        int counter = 0;
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i <= cycle; i++) {
            if (cycle % i == 0) {
                counter++;
            }
        }
        if (counter > 1) {
            return false;
        }
        return true;
    }

}
