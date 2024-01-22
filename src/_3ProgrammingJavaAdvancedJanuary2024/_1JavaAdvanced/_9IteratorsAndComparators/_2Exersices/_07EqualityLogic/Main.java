package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._07EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Person> hashSet = new HashSet<>();
        TreeSet<Person> treeSet = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            hashSet.add(person);
            treeSet.add(person);
        }
        System.out.printf("%d%n",treeSet.size());
        System.out.printf("%d%n",hashSet.size());
    }
}
