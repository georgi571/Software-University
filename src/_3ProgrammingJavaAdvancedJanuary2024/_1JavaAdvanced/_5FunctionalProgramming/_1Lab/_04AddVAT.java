package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._1Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        Function<Double, Double> addVat = price -> price * 1.2;
        Consumer<Double> printFormatPrice = price -> System.out.printf("%.2f%n", price);
        System.out.printf("Prices with VAT:%n");
        for (Double price : prices) {
            double priceWithVat = addVat.apply(price);
            printFormatPrice.accept(priceWithVat);
        }
    }
}
