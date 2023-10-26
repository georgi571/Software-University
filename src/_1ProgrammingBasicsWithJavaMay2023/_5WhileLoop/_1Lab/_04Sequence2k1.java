package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._1Lab;

import java.util.Scanner;

public class _04Sequence2k1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int num = 1;
        while (num <= n) {
            System.out.println(num);
            num = num * 2 + 1;
        }
    }
}
