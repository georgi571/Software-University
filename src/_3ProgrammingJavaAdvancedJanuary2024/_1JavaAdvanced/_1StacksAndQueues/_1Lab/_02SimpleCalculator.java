package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._1StacksAndQueues._1Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> calculator = new ArrayDeque<>();
        String[] text = scanner.nextLine().split(" ");
        int sum = 0;
        for (int i = 0; i < text.length; i++) {
            if (i == 0) {
                calculator.add(Integer.parseInt(text[i]));
            } else {
                if (text[i].equals("-")) {
                    int number = -1 * Integer.parseInt(text[i + 1]);
                    calculator.add(number);
                } else if (text[i].equals("+")){
                    int number = Integer.parseInt(text[i + 1]);
                    calculator.add(number);
                }
                i++;
            }
        }
        while (!calculator.isEmpty()) {
            int currentNumber = calculator.pop();
            sum += currentNumber;
        }
        System.out.printf("%d", sum);
    }
}
