package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._1Lab;

import java.util.Scanner;

public class _06MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int maxNumber = Integer.MIN_VALUE;
        while (!input.equals("Stop")) {
            int number = Integer.parseInt(input);
            if (number > maxNumber) {
                maxNumber = number;
            }
        input = scanner.nextLine();
        }
        System.out.printf("%d",maxNumber);
    }
}
