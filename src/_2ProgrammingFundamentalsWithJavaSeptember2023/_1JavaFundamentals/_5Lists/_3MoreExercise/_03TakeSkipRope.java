package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._3MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("");
        List<Integer> numbers = new ArrayList<>();
        List<Character> nonNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        String hidenText = "";
        for (int i = 0; i < text.length; i++) {
            boolean isCharisDigit = Character.isDigit(text[i].charAt(0));
            if (isCharisDigit) {
                numbers.add(Integer.parseInt(text[i]));
            } else {
                nonNumbers.add(text[i].charAt(0));
            }
        }
        for (int i = 1; i <= numbers.size(); i++) {
            if (i % 2 == 0) {
                evenNumbers.add(numbers.get(i - 1));
            } else {
                oddNumbers.add(numbers.get(i - 1));
            }
        }
        for (int i = 0; i < oddNumbers.size(); i++) {
            for (int j = 0; j < oddNumbers.get(i); j++) {
                if (nonNumbers.size() == 0) {
                    break;
                } else {
                    char currentSymbol = nonNumbers.get(0);
                    nonNumbers.remove(0);
                    hidenText += currentSymbol;
                }
            }
            for (int j = 0; j < evenNumbers.get(i); j++) {
                if (nonNumbers.size() == 0) {
                    break;
                } else {
                    nonNumbers.remove(0);
                }
            }
        }
        System.out.printf("%s", hidenText);
    }
}
