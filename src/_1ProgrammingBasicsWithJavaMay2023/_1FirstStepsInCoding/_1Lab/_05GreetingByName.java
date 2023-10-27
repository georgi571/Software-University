package _1ProgrammingBasicsWithJavaMay2023._1FirstStepsInCoding._1Lab;

import java.util.Scanner;

public class _05GreetingByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!", name);
    }
}
