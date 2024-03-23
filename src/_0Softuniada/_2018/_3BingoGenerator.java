package _0Softuniada._2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3BingoGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String first = String.valueOf(n.charAt(0)) + String.valueOf(n.charAt(2));
        String second = String.valueOf(n.charAt(1)) + String.valueOf(n.charAt(3));
        String element = first + second;
        int firstNumber = Integer.parseInt(first);
        int secondNumber = Integer.parseInt(second);
        int ceil = firstNumber + secondNumber;
        int startElement = Integer.parseInt(element);
        List<Integer> divisionBy12 = new ArrayList<>();
        List<Integer> divisionBy15 = new ArrayList<>();
        int counter = 0;
        for (int i = firstNumber; i <= ceil; i++) {
            int newFirst = (firstNumber + counter) * 100;
            int counter2 = 0;
            for (int j = secondNumber; j <= ceil; j++) {
                int newSecond = secondNumber + counter2;
                counter2++;
                int newNumber = newFirst + newSecond;
                if (newNumber % 12 == 0) {
                    divisionBy12.add(newNumber);
                }
                if (newNumber % 15 == 0) {
                    divisionBy15.add(newNumber);
                }
            }
            counter++;
        }
        System.out.printf("Dividing on 12:");
        for (Integer i : divisionBy12) {
            System.out.printf(" %d", i);
        }
        System.out.printf("%nDividing on 15:");
        for (Integer i : divisionBy15) {
            System.out.printf(" %d", i);
        }
        if (divisionBy12.size() == divisionBy15.size()) {
            System.out.printf("%n!!!BINGO!!!");
        } else {
            System.out.printf("%nNO BINGO!");
        }
    }
}
