package _0Softuniada._2018;

import java.util.Scanner;

public class _0AwesomeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        if (n % 2 == 1 || n % 2 == -1) {
            counter++;
        }
        if (n < 0) {
            counter++;
        }
        if (n % m == 0) {
            counter++;
        }
        if (counter == 0) {
            System.out.printf("boring");
        } else if (counter == 1) {
            System.out.printf("awesome");
        } else if (counter == 2) {
            System.out.printf("super awesome");
        } else if (counter == 3){
            System.out.printf("super special awesome");
        }
    }
}
