package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> nameSet = new TreeSet<>(new NameComparator());
        Set<Person> ageSet = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            nameSet.add(person);
            ageSet.add(person);
        }
        nameSet.forEach(System.out::println);
        ageSet.forEach(System.out::println);
    }
}
