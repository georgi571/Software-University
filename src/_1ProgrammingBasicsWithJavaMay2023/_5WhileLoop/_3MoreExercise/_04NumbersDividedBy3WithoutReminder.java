package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._3MoreExercise;

import java.util.Scanner;

public class _04NumbersDividedBy3WithoutReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.printf("%d%n", i);
            }
        }
    }
}
