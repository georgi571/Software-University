package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._1Lab._03ValidationData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }
        double bonus = Double.parseDouble(scanner.nextLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}
