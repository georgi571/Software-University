package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._04Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] elements = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Lake lake = new Lake(elements);
        String command = scanner.nextLine();
        Iterator<Integer> iterator = lake.iterator();
        boolean isNotLast = false;
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            isNotLast = iterator.hasNext();
            if (isNotLast) {
                System.out.printf("%s, ", element);
            } else {
                System.out.printf("%s", element);
            }
        }
    }
}
