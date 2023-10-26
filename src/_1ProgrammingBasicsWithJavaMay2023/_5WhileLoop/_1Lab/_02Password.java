package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._1Lab;

import java.util.Scanner;

public class _02Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String currentPassword = scanner.nextLine();
        while (!currentPassword.equals(password)) {
            currentPassword = scanner.nextLine();
        }
        System.out.printf("Welcome %s!", username);
    }
}
