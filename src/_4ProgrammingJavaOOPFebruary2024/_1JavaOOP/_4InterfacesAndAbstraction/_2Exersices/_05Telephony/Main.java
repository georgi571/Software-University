package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._05Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine()
                                .split("\\s+"))
                        .collect(Collectors.toList());
        List<String> urls = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        Smartphone smartphone = new Smartphone(numbers, urls);
        System.out.printf("%s%n",smartphone.call());
        System.out.printf("%s%n",smartphone.browse());
    }
}
