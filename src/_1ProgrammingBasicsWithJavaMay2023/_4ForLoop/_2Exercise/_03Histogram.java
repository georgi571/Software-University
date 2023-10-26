package _1ProgrammingBasicsWithJavaMay2023._4ForLoop._2Exercise;

import java.util.Scanner;

public class _03Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber < 200) {
                p1++;
            } else if (currentNumber <= 399) {
                p2++;
            } else if (currentNumber <= 599) {
                p3++;
            } else if (currentNumber <= 799) {
                p4++;
            } else if (currentNumber >= 800) {
                p5++;
            }
        }
        int sum = p1 + p2 + p3 + p4 +p5;
        double percentOfp1 = (1.0*p1 / sum) * 100;
        double percentOfp2 = (1.0*p2 / sum) * 100;
        double percentOfp3 = (1.0*p3 / sum) * 100;
        double percentOfp4 = (1.0*p4 / sum) * 100;
        double percentOfp5 = (1.0*p5 / sum) * 100;
        System.out.printf("%.2f%%%n",percentOfp1);
        System.out.printf("%.2f%%%n",percentOfp2);
        System.out.printf("%.2f%%%n",percentOfp3);
        System.out.printf("%.2f%%%n",percentOfp4);
        System.out.printf("%.2f%%%n",percentOfp5);
    }
}
