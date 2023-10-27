package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._1Lab;

import java.util.Scanner;

public class _03EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        if (num % 2 == 0){
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
