package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._2Exercises._06GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Double input = Double.valueOf(scanner.nextLine());
            Box<Double> box = new Box<>(input);
            boxList.add(box);
        }
        Box<Double> boxToCompare = new Box<>(Double.parseDouble(scanner.nextLine()));
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
