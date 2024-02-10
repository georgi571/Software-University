package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._06Animals.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equals("Beast!")) {
            try {
                String[] info = scanner.nextLine().split("\\s+");
                if (command.equals("Dog")) {
                    Dog dog = new Dog(info[0], Integer.parseInt(info[1]), info[2]);
                    System.out.printf("%s%n", dog);
                } else if (command.equals("Frog")) {
                    Frog frog = new Frog(info[0], Integer.parseInt(info[1]), info[2]);
                    System.out.printf("%s%n", frog);
                } else if (command.equals("Cat")) {
                    Cat cat = new Cat(info[0], Integer.parseInt(info[1]), info[2]);
                    System.out.printf("%s%n", cat);
                } else if (command.equals("Kitten")) {
                    Kitten kitten = new Kitten(info[0], Integer.parseInt(info[1]));
                    System.out.printf("%s%n", kitten);
                } else if (command.equals("Tomcat")) {
                    Tomcat tomcat = new Tomcat(info[0], Integer.parseInt(info[1]));
                    System.out.printf("%s%n", tomcat);
                }
            } catch (IllegalArgumentException exception) {
                System.out.printf("%s%n", exception.getMessage());
            }
            command = scanner.nextLine();
        }
    }
}