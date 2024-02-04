package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._2Exersices._01ClassBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        Box box = new Box(length, width, height);
        box.print();
    }
}
