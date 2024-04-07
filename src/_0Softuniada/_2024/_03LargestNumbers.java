package _0Softuniada._2024;

import java.util.Arrays;
import java.util.Scanner;

public class _03LargestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());
        int[] array = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            array[i] = Integer.parseInt(inputArray[i]);
        }
        Arrays.sort(array);
        for (int i = array.length - k ; i <= array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }
}