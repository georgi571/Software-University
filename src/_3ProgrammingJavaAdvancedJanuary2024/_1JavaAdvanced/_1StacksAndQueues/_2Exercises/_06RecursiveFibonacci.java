package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._2Exercises;

import java.util.Scanner;

public class _06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n +1];
        long result = fib(n);
        System.out.printf("%d", result);
    }

    private static long[] memory;
    private static long fib(int n) {
        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = fib(n -1) + fib(n - 2);
        return memory[n];
    }
}
