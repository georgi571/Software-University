package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        printAllCharBetween(symbol1, symbol2);
    }
    public static void printAllCharBetween(char symbol1, char symbol2){
        if (symbol1 < symbol2){
            for (int i = symbol1 + 1; i < symbol2; i++) {
                System.out.printf("%c ", i);
            }
        } else {
            for (int i = symbol2 + 1; i < symbol1; i++) {
                System.out.printf("%c ", i);
            }
        }
    }
}
