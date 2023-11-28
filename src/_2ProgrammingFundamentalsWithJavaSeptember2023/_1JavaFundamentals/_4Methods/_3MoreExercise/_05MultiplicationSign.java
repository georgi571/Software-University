package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._3MoreExercise;

import java.util.Scanner;

public class _05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        printResult(n1, n2, n3);
    }
    private static void printResult(int n1, int n2, int n3) {
        if (n1 == 0 || n2 == 0 || n3 == 0) {
            System.out.printf("zero%n");
        } else {
            if (n1 < 0) {
                if (n2 > 0) {
                    if (n3 > 0) {
                        System.out.printf("negative%n");
                    } else {
                        System.out.printf("positive%n");
                    }
                } else {
                    if (n3 > 0) {
                        System.out.printf("positive%n");
                    } else {
                        System.out.printf("negative%n");
                    }
                }
            } else {
                if (n2 > 0) {
                    if (n3 > 0) {
                        System.out.printf("positive%n");
                    } else {
                        System.out.printf("negative%n");
                    }
                } else {
                    if (n3 > 0) {
                        System.out.printf("negative%n");
                    } else {
                        System.out.printf("positive%n");
                    }
                }
            }
        }
    }
}
