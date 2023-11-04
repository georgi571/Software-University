package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._1Lab;

import java.util.Scanner;

public class _09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        if (type.equals("int")) {
            int number1 = Integer.parseInt(scanner.nextLine());
            int number2 = Integer.parseInt(scanner.nextLine());
            getMax(number1, number2);
        } else if (type.equals("char")) {
            char char1 = scanner.nextLine().charAt(0);
            char char2 = scanner.nextLine().charAt(0);
            getMax(char1, char2);
        } else if (type.equals("string")) {
            String text1 = scanner.nextLine();
            String text2 = scanner.nextLine();
            getMax(text1, text2);
        }
    }
    private static void getMax(int number1, int number2) {
        if (number1 > number2) {
            System.out.printf("%d", number1);
        } else {
            System.out.printf("%d", number2);
        }
    }
    private static void getMax(char char1, char char2) {
        if (char1 > char2) {
            System.out.printf("%c", char1);
        } else {
            System.out.printf("%c", char2);
        }
    }
    private static void getMax(String text1, String text2) {
        if (text1.compareTo(text2) >= 0) {
            System.out.printf("%s", text1);
        } else {
            System.out.printf("%s", text2);
        }
    }
}
