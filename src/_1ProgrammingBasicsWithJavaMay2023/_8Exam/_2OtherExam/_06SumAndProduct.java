package _1ProgrammingBasicsWithJavaMay2023._8Exam._2OtherExam;

import java.util.Scanner;

public class _06SumAndProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int lastDigit = n % 10;
        int division = n % 3;
        if (lastDigit != 5 && division != 0) {
            System.out.printf("Nothing found%n");
        } else {
            boolean isFoundNumber = false;
            for (int a = 1; a <= 9; a++) {
                for (int b = 9; b >= a; b--) {
                    for (int c = 0; c <= 9; c++) {
                        for (int d = 9; d >= c; d--) {
                            int sum = a + b + c + d;
                            int product = a * b * c * d;
                            if (sum == product && n % 10 == 5) {
                                System.out.printf("%d%d%d%d%n", a, b, c, d);
                                isFoundNumber = true;
                            } else if (product / sum == 3 && n % 3 == 0) {
                                System.out.printf("%d%d%d%d%n", d, c, b, a);
                                isFoundNumber = true;
                            }
                            if (isFoundNumber) {
                                break;
                            }
                        }
                        if (isFoundNumber) {
                            break;
                        }
                    }
                    if (isFoundNumber) {
                        break;
                    }
                }
                if (isFoundNumber) {
                    break;
                }
            }
        }
    }
}
