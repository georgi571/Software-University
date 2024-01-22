package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] inputParts = input.split("\\s+");
            Person person = new Person(inputParts[0], Integer.parseInt(inputParts[1]), inputParts[2]);
            personList.add(person);


            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person personToCompare = personList.get(n - 1);
        int equals = 0;
        int diff = 0;
        for (Person person : personList) {
            int result = personToCompare.compareTo(person);
            if (result == 0) {
                equals++;
            } else {
                diff++;
            }
        }
        if (equals <= 1) {
            System.out.printf("No matches%n");
        } else {
            System.out.printf("%d %d %d%n", equals, diff, personList.size());
        }
    }
}
