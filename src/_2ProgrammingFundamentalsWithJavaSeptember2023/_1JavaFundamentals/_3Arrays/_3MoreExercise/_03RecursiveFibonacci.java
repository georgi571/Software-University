package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._3MoreExercise;

import java.util.Scanner;
import java.util.WeakHashMap;

public class _03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        if (n == 1) {
            array[0] = 1;
        }else if (n == 2) {
            array[0] = 1;
            array[1] = 1;
        }else if (n > 2) {
            array[0] = 1;
            array[1] = 1;
            int firstNumber = array[0];
            int secondNumber = array[1];
            for (int i = 2; i < n; i++) {
                array[i] = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = array[i];
            }
        }
        System.out.printf("%d",array[n - 1]);
    }
}
