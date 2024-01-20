package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._2Exercises._01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<>(input);
            box.toString();
        }
    }
}
