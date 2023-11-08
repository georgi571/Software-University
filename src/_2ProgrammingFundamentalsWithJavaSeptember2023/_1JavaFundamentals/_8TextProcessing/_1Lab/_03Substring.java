package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._1Lab;

import java.util.Scanner;

public class _03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();
        while (true) {
            int index = secondString.indexOf(firstString);
            if (index == -1) {
                break;
            }
            String leftString = secondString.substring(0, index);
            String rightString = secondString.substring(index + firstString.length());
            secondString = leftString.concat(rightString);
        }
        System.out.printf("%s", secondString);
    }
}
