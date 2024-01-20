package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._2Exercises._05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            boxList.add(box);
        }
        Box<String> boxToCompare = new Box<>(scanner.nextLine());
        int results = countGreaterResults(boxList, boxToCompare);
        System.out.printf("%d%n", results);
    }

    private static <T extends Comparable<T>> int countGreaterResults(List<T> boxList, T boxToCompare) {
        int count = 0;
        for (T t : boxList) {
            int result = t.compareTo(boxToCompare);
            if (result > 0) {
                count++;
            }
        }

        return count;
    }
}
