package _1ProgrammingBasicsWithJavaMay2023._5WhileLoop._1Lab;

import java.util.Scanner;

public class _01ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            System.out.println(input);
            input = scanner.nextLine();
        }
    }
}
