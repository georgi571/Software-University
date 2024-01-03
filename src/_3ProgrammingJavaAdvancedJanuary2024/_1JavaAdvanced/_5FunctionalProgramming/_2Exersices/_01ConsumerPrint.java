package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._5FunctionalProgramming._2Exersices;

import java.util.Scanner;
import java.util.function.Consumer;

public class _01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String> printName = name -> System.out.printf("%s%n", name );
        for (String name : names) {
            printName.accept(name);
        }
    }
}
