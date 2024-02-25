package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _06UniquePinCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= first; i+=2) {
            for (int j = 1; j <= second; j++) {
                if (j == 2 || j == 3 || j == 5 || j == 7) {
                    for (int k = 2; k <= third; k+=2) {
                        System.out.printf("%d%d%d%n", i, j, k);
                    }
                }
            }
        }
    }
}
