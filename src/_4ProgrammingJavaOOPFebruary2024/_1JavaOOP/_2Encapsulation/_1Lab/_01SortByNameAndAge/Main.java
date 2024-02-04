package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._2Encapsulation._1Lab._01SortByNameAndAge;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }
        Collections.sort(people, Comparator.comparing(Person::getFirstName).thenComparingInt(Person::getAge));
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
