package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        printSmallestNumber(firstNumber, secondNumber, thirdNumber);
    }
    public static void printSmallestNumber(int n1, int n2, int n3){
        if (n1 < n2 && n1 < n3) {
            System.out.printf("%d", n1);
        } else if (n2 < n1 && n2 < n3) {
            System.out.printf("%d", n2);
        } else {
            System.out.printf("%d", n3);
        }
    }
}
