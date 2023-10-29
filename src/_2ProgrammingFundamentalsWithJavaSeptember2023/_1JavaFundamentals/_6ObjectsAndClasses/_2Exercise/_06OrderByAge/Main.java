package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._2Exercise._06OrderByAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] input = command.split(" ");
            String name = input[0];
            String id = input[1];
            int age = Integer.parseInt(input[2]);
            Person person = new Person(name, id, age);
            personList.add(person);
            command = scanner.nextLine();
        }
        Collections.sort(personList, Comparator.comparingInt(Person::getAge));
        for (Person person : personList) {
            System.out.printf("%s with ID: %s is %d years old.%n",person.getName(),person.getId(), person.getAge());
        }
    }
}
