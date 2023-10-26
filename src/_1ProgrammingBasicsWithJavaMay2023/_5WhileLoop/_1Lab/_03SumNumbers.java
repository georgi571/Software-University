package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._1Lab;

import java.util.Scanner;

public class _03SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (sum < num) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            sum += currentNum;
        }
        System.out.printf("%d",sum);
    }
}
