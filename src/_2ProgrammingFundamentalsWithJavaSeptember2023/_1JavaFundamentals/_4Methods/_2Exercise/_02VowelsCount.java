package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        printCountVowels(text);
    }
    public static void printCountVowels(String text) {
        int count = 0;
        for (char letter : text.toCharArray()){
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
