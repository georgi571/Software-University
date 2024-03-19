package _0Softuniada._2016;

import java.util.Scanner;

public class _01GroupsOfEqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int n4 = Integer.parseInt(scanner.nextLine());
        int num = 0;
        boolean isFind = false;
        if (n1 == n2 + n3 + n4) {
            num = n1;
            isFind = true;
        }
        if (n2 == n1 + n3 + n4) {
            num = n2;
            isFind = true;
        }
        if (n3 == n1 + n2 + n4) {
            num = n3;
            isFind = true;
        }
        if (n4 == n1 + n2 + n3) {
            num = n4;
            isFind = true;
        }
        if (n1 + n2 == n3 + n4) {
            num = n1 + n2;
            isFind = true;
        }
        if (n1 + n3 == n2 + n4) {
            num = n1 + n3;
            isFind = true;
        }
        if (n1 + n4 == n2 + n3) {
            num = n1 + n4;
            isFind = true;
        }
        if (isFind) {
            System.out.printf("Yes%n");
            System.out.printf("%d%n", num);
        } else {
            System.out.printf("No%n");
        }
    }
}
