package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._3SetsAndMapsAdvanced._2Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> text = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            text.add(scanner.nextLine());
        }
        for (String s : text) {
            System.out.printf("%s%n",s);
        }
    }
}
