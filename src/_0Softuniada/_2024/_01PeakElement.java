package _0Softuniada._2024;

import java.util.Scanner;

public class _01PeakElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int maxPeak = Integer.MIN_VALUE;
        int peakElement = Integer.MIN_VALUE;
        for (int i = 1; i < input.length - 1; i++) {
            int current = Integer.parseInt(input[i]);
            int previous = Integer.parseInt(input[i - 1]);
            int next = Integer.parseInt(input[i + 1]);
            if (current > previous && current > next && current > maxPeak) {
                maxPeak = current;
                peakElement = current;
            }
        }
        int first = Integer.parseInt(input[0]);
        int last = Integer.parseInt(input[input.length - 1]);
        if (first > Integer.parseInt(input[1]) && first > maxPeak) {
            peakElement = first;
            maxPeak = first;
        }
        if (last > Integer.parseInt(input[input.length - 2]) && last > maxPeak) {
            peakElement = last;
        }
        System.out.printf("%d", peakElement);
    }
}
