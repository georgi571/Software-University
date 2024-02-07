package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._01Person.person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Child child = new Child(name, age);
        System.out.println(child.getName());
        System.out.println(child.getAge());
    }
}
