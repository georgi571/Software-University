package _1ProgrammingBasicsWithJavaMay2023._4ForLoop._1Lab;

import java.util.Scanner;

public class _07SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            sum = sum + currentNum;
        }
        System.out.println(sum);
    }
}
