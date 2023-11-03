package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._1Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList1 = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> numbersList2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> results = new ArrayList<>();
        int size;
        if (numbersList1.size() >= numbersList2.size()) {
            size = numbersList1.size();
        } else {
            size = numbersList2.size();
        }
        for (int i = 0; i < size ; i++) {
            if (numbersList1.size() - 1 >= i) {
                results.add(numbersList1.get(i));
            }
            if (numbersList2.size() - 1 >= i) {
                results.add(numbersList2.get(i));
            }
        }
        for (int i = 0; i < results.size() - 1; i++) {
            System.out.printf("%d ", results.get(i));
        }
        System.out.printf("%d", results.get(results.size() - 1));
    }
}
