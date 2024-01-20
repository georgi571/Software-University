package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._2Exercises._10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String city = input[2];
        Tuple<String, String> firstTuple = new Tuple<>(name, city);
        System.out.printf("%s%n", firstTuple);
        input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        int littersOfBeer = Integer.parseInt(input[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(firstName, littersOfBeer);
        System.out.printf("%s%n", secondTuple);
        input = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(input[0]);
        double decimal = Double.parseDouble(input[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(number, decimal);
        System.out.printf("%s%n", thirdTuple);
    }
}
