package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._1Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0) {
            System.out.printf("%d", n);
        }
        while (n != 0) {
            binary.push(n % 2);
            n /= 2;

        }
        while (!binary.isEmpty()) {
            System.out.printf("%d", binary.pop());
        }
    }
}
