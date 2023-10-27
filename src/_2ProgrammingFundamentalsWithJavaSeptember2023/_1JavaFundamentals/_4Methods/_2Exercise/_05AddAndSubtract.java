package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._2Exercise;

import java.util.Scanner;

public class _05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int sum = sum(firstNumber, secondNumber);
        int subtract = subtract(sum, thirdNumber);
        System.out.println(subtract);
    }
    public static int sum(int n1, int n2) {
        int sum = n1 + n2;
        return sum;
    }
    public static int subtract (int n1, int n2) {
        int substract = n1 - n2;
        return substract;
    }
}
