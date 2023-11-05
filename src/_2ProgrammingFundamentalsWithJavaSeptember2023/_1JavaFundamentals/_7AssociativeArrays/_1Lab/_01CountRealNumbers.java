package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._1Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Double, Integer> numbersCount = new TreeMap<>();
        double[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        for (double num : nums) {
            if (numbersCount.containsKey(num)) {
                numbersCount.put(num, numbersCount.get(num) + 1);
            } else {
                numbersCount.put(num, 1);
            }
        }
        for (Map.Entry<Double, Integer> kvp : numbersCount.entrySet()) {
            String keyFormat = new DecimalFormat("#.####").format(kvp.getKey());
            System.out.printf("%s -> %d%n", keyFormat, kvp.getValue());
        }
    }
}
