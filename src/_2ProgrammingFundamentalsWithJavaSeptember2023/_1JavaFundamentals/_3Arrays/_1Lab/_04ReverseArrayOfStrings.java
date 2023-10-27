package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = scanner.nextLine().split(" ");
        for (int i = elements.length - 1; i >= 0; i--) {
            System.out.print(elements[i] + " ");
        }
    }
}
