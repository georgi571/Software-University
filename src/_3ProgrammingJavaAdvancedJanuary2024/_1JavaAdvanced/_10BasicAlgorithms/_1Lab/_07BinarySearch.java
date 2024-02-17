package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._10BasicAlgorithms._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _07BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int key = Integer.parseInt(scanner.nextLine());
        int index = getIndex(array, key);
        System.out.printf("%d", index);
    }
    public static int getIndex(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < array[mid]) {
                end = mid - 1;
            } else if (key > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
