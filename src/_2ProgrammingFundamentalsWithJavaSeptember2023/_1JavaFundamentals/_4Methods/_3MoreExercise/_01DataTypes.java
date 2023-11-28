package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._3MoreExercise;

import java.util.Scanner;

public class _01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String input = scanner.nextLine();
        printTheResult(command, input);
    }
    private static void printTheResult(String command, String input) {
        if (command.equals("int")) {
            int number = Integer.parseInt(input);
            System.out.printf("%d%n", number * 2);
        } else if (command.equals("real")) {
            double number = Double.parseDouble(input);
            System.out.printf("%.2f%n", number * 1.5);
        } else if (command.equals("string")) {
            System.out.printf("$%s$%n", input);
        }
    }
}
