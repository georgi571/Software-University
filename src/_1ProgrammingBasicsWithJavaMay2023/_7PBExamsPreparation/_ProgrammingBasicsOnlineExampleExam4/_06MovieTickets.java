package _1ProgrammingBasicsWithJavaMay2023._7PBExamsPreparation._ProgrammingBasicsOnlineExampleExam4;

import java.util.Scanner;

public class _06MovieTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = Integer.parseInt(scanner.nextLine());
        int a2 = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = a1; i < a2; i++) {
            if (i % 2 == 1) {
                for (int j = 1; j <= n - 1; j++) {
                    for (int k = 1; k <= (n / 2) - 1; k++) {
                        int sumOfSecondThirdAndFourth = j + k + i;
                        if (sumOfSecondThirdAndFourth % 2 == 1) {
                            System.out.printf("%c-%d%d%d%n", i, j, k, i);
                        }
                    }
                }
            }
        }
    }
}
