package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.*;

public class _02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 0; i < size[0]; i++) {
            set1.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < size[1]; i++) {
            set2.add(Integer.parseInt(scanner.nextLine()));
        }
        for (Integer number1 : set1) {
            for (Integer number2 : set2) {
                if (number1 == number2) {
                    System.out.printf("%d ", number1);
                }
            }
        }
    }
}
