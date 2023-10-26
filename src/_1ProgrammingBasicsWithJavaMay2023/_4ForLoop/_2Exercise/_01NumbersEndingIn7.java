package _1ProgrammingBasicsWithJavaMay2023._4ForLoop._2Exercise;

import java.util.Scanner;

public class _01NumbersEndingIn7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 7; i <=997; i++) {
            if (i % 10 == 7) {
                System.out.println(i);
            }
        }
    }
}
